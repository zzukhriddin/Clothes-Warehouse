package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.mapper.IncomeMaterialMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import com.sigma.clotheswarehouse.repository.IncomeMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeMaterialService {

    private final IncomeMaterialRepository incomeMaterialRepo;

    private final IncomeMaterialMapper incomeMaterialMapper;


    public ApiResponse addIncomeMaterial(List<IncomeMaterialDTO> incomeMaterialDTOList) {
        List<IncomeMaterial> incomeMaterialList = new LinkedList<>();
        for (IncomeMaterialDTO incomeMaterialDTO : incomeMaterialDTOList) {
            IncomeMaterial incomeMaterial = incomeMaterialMapper.incomeMaterialDTOToIncomeMaterial(incomeMaterialDTO);
            incomeMaterialList.add(incomeMaterial);
        }
        incomeMaterialRepo.saveAll(incomeMaterialList);
        return new ApiResponse(true, "Successfully saved");
    }
}
