package com.koddy.integrationTest.buyout.supplier;

import com.koddy.integrationTest.buyout.dto.BuyoutDto;
import com.koddy.util.RequestUtil;

import java.math.BigDecimal;
import java.util.function.Supplier;
/**
 * TEMPLATE
 * {
 *     "buyout": {
 *         "provider_id": 44,
 *         "date": "2023-03-01",
 *         "description": "compra test",
 *         "amount": 10,
 *         "employee_id": 24,
 *         "paid": "0",
 *         "file": "0"
 *     }
 * }
 */
public class BuyoutSupplier {
    public static BuyoutDto get(){
        BuyoutDto buyoutDto = new BuyoutDto();
        buyoutDto.setProviderId(44);
        buyoutDto.setDate("2023-03-01");
        buyoutDto.setDescription("Buyout demo: "+ RequestUtil.generateCode());
        buyoutDto.setAmount(new BigDecimal("10"));
        buyoutDto.setEmployeeId(24);
        buyoutDto.setPaid("0");
        buyoutDto.setFile("0");
        return buyoutDto;
    }
}
