package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.exceptions.PageSizeException;
import com.sigma.clotheswarehouse.mapper.IncomeMaterialMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import com.sigma.clotheswarehouse.repository.IncomeMaterialRepository;
import com.sigma.clotheswarehouse.utils.CommandUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            IncomeMaterial incomeMaterial = incomeMaterialMapper.generateIncomeMaterialFromIncomeMaterialDTO(incomeMaterialDTO);
            incomeMaterialList.add(incomeMaterial);
        }
        incomeMaterialRepo.saveAll(incomeMaterialList);
        return new ApiResponse(true, "Successfully saved");
    }

    public ApiResponse getAllIncomeMaterials(Integer page, Integer size) {
        List<IncomeMaterialDTO> incomeMaterialDTOList = new ArrayList<>();
        Page<IncomeMaterial> incomeMaterialPage;
        try {
            incomeMaterialPage = incomeMaterialRepo.findAll(CommandUtils.simplePageable(page, size));
        } catch (PageSizeException e) {
            return new ApiResponse(false, e.getMessage());
        }
        for (IncomeMaterial incomeMaterial : incomeMaterialPage) {
            IncomeMaterialDTO incomeMaterialDTO = incomeMaterialMapper.generateIncomeMaterialDTOFromIncomeMaterial(incomeMaterial);
            incomeMaterialDTOList.add(incomeMaterialDTO);
        }
        return new ApiResponse(true, "Income materials with Page", incomeMaterialDTOList);
    }
}
