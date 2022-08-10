package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.Client;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.ClientGetDto;
import com.sigma.clotheswarehouse.payload.ClientPostDto;
import com.sigma.clotheswarehouse.payload.ClientUpdateDto;
import com.sigma.clotheswarehouse.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    public ApiResponse addClient(ClientPostDto clientPostDto) {
        if (clientRepository.findByPhoneNumber(clientPostDto.getPhoneNumber()).isPresent()) {
               return new ApiResponse(false, "Phone number is exist");
        }
        Client client = new Client(clientPostDto.getFio(), clientPostDto.getPhoneNumber(), clientPostDto.getAddress(), false);
        clientRepository.save(client);
        return new ApiResponse(true,"Successfully saved");
    }


    public ApiResponse getById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()){
            return new ApiResponse(false,"Such a client does not exist");
        }
        Client client = clientOptional.get();
        ClientGetDto clientGetDto = new ClientGetDto();
        clientGetDto.setId(client.getId());
        clientGetDto.setFio(client.getFio());
        clientGetDto.setPhoneNumber(client.getPhoneNumber());
        clientGetDto.setAddress(client.getAddress());
        clientGetDto.setDeleted(client.isDeleted());

        return new ApiResponse(true,"Success",clientGetDto);
    }

    public ApiResponse getClients() {
        List<Client> clientList = clientRepository.findAll();
        List<ClientGetDto> clientGetDtoList = new LinkedList<>();
        if (clientList.isEmpty()){
            return new ApiResponse(false, "There isn't client");
        }
        for (Client client : clientList) {
            ClientGetDto clientGetDto = new ClientGetDto();
            clientGetDto.setId(client.getId());
            clientGetDto.setFio(client.getFio());
            clientGetDto.setPhoneNumber(client.getPhoneNumber());
            clientGetDto.setAddress(client.getAddress());
            clientGetDto.setDeleted(client.isDeleted());
            clientGetDtoList.add(clientGetDto);
        }
        return new ApiResponse(true, "All Clients",clientGetDtoList);
    }

    public ApiResponse updateClient(long id, ClientUpdateDto clientUpdateDto) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()){
            return new ApiResponse(false,"Such a client does not exist");
        }
        Optional<Client> optionalClient = clientRepository.findByPhoneNumber(clientUpdateDto.getPhoneNumber());
        if (optionalClient.isPresent()) {
            Client clientByPhone = optionalClient.get();
            if (id != clientByPhone.getId()) {
                return new ApiResponse(false, "Phone number is exist");
            }
        }
        Client client = clientOptional.get();
        client.setFio(clientUpdateDto.getFio());
        client.setPhoneNumber(clientUpdateDto.getPhoneNumber());
        client.setAddress(clientUpdateDto.getAddress());
        client.setDeleted(clientUpdateDto.isDeleted());
        clientRepository.save(client);
        return new ApiResponse(true,"Client updated successfully");
    }

    public ApiResponse deleteClient(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()){
            return new ApiResponse(false,"Such a material does not exist");
        }
        Client client = clientOptional.get();
        client.setDeleted(true);
        clientRepository.save(client);
        return new ApiResponse(true, "Client successfully deleted");
    }
}
