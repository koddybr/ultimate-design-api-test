package com.koddy.integrationTest.clients.supplier;

import com.koddy.integrationTest.clients.dto.ClientDto;
import com.koddy.util.RequestUtil;
import org.junit.platform.commons.util.StringUtils;

public class ClientSupplier {

    public static ClientDto get(){
       ClientDto clientDto = new ClientDto();
       clientDto.setName("Client: "+ RequestUtil.generateCode());
       clientDto.setNit(RequestUtil.generateCode());
       clientDto.setAddress("Demo address");
       clientDto.setLegalRepresentative("QA representative");
       clientDto.setPhone("+1111111");
       clientDto.setEmail("qa@email.com");
       clientDto.setDescription("qa api client");
       return clientDto;
    }

    public static ClientDto getFirstRow(){
       ClientDto clientDto = new ClientDto();
       clientDto.setId(1);
       clientDto.setName("Nogmat SRL");
       clientDto.setNit("380173026");
       clientDto.setDescription("Productos Stock");
       return clientDto;
    }
}
