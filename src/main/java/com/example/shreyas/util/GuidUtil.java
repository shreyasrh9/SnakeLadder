/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shreyas.util;

import java.util.UUID;
/**
 * Author: Mark Washburn
 *
 * Creation Date: 08-22-2008
 *
 * Description:  This class provides many methods which can be used for date/time manipulations.
 * Any other date/time manipulation logic will be added to this class. This will serve as a common
 * code for all the date/time manipulation logics in the project. *
 * Revision History:
 *-----------------------------------------------------------------------------------------------------
 * Version		 Date		 		 Developer                   Description
 *-----------------------------------------------------------------------------------------------------
 * 1.0	 		 08-22-2008                     Mark Washburn               Initial Version
 * 1.1			 05-15-2009			Pradas Kalam		Updated Randama Logic
 *-----------------------------------------------------------------------------------------------------
 */
public class GuidUtil {

    /**
     *  Method to get unique identifer (guid)
     *  @return string format of the guid
     */
    public static String getId() {
        String uuid = UUID.randomUUID().toString();
        uuid = hexEncode(uuid.getBytes());
        return uuid.substring(0, 49);
    }

    private static String hexEncode(byte[] aInput) {
        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int index = 0; index < aInput.length; ++index) {
            byte b = aInput[index];
            result.append(digits[(b & 0xf0) >> 4]);
            result.append(digits[b & 0x0f]);
        }
        return result.toString();
    }
}
