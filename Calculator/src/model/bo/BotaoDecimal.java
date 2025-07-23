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

import javafx.scene.control.Button;

/**
 *
 * @author Lucas Garcia and Pedro Lucas
 * @date 03/11/2024
 * @brief Class BotaoDecimal
 *
 **/

public class BotaoDecimal {

    public BotaoDecimal() {
    }
    
    public static void AtivarBotao(Button button){
        button.setDisable(false);
    }
    public static void DesativarBotao(Button button){
        button.setDisable(true);
    }
}
