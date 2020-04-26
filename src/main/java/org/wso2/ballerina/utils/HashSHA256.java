/*
*   Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.ballerina.utils;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class HashSHA256 {
    public static String execute(String inputString) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(inputString.getBytes(StandardCharsets.UTF_8));

            BigInteger number = new BigInteger(1, hash);

            // Convert message digest into hex value
            StringBuilder hexString = new StringBuilder(number.toString(16));

            // Pad with leading zeros
            while (hexString.length() < 32)
            {
                hexString.insert(0, '0');
            }

            result = hexString.toString();

        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }
}