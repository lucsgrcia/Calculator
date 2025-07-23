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

package model.bo;

import model.vo.Numbers;

/**
 *
 * @author Lucas Garcia and Pedro Lucas
 * @date 03/11/2024
 * @brief Class Properties
 *
 **/

public class Properties {
    
    Numbers n = new Numbers();

    public Properties(Numbers n) {
        this.n = n;
    }
    
    public Double soma(){
        
        return n.getNum1() + n.getNum2();
    }
    
    public Double subtracao(){
        
        return n.getNum1() - n.getNum2();
    }
    
    public Double multiplicacao(){
        
        return n.getNum1() * n.getNum2();
    }
    
    public Double divisao(){
        
        return n.getNum1() / n.getNum2();
    }
    
    public Double exponenciacao(){
        
        return Math.pow(n.getNum1(), n.getNum2());
    }
    
    public Double sqrt(){
        
        return Math.sqrt(n.getNum2());
    }
    
    public Double porcentagem(String operador){
        
        double num;
        if ("+".equals(operador) || "-".equals(operador)) {
                    num = (n.getNum2() / 100) * n.getNum1();
                } else {
                    num = n.getNum2() / 100;
                }
        
        return num;
    }

}
