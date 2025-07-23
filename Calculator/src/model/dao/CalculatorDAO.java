/*
 * Copyright (C) 2024 Lucas Garcia and Pedro Lucas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package model.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Lucas Garcia and Pedro Lucas
 * @date 03/11/2024
 * @brief Class CalculatorDAO
 *
 **/

public class CalculatorDAO {
    
    public static void salvarDados(List<String> list){
        
        boolean success = new File("c:\\Temp").mkdir();
        String file = "c:\\Temp\\output.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String x : list) {
                bw.write(x);
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

}
