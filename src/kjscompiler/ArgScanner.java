/*
 * kjscompiler
 * Copyright (C) 2014  Oleksandr Knyga, oleksandrknyga@gmail.com
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

package kjscompiler;

import java.util.Hashtable;

/**
 *
 * @author agnynk
 */
public class ArgScanner {
    private String[] args;
    private Hashtable<String, String> table;
    
    private String prefix = "--";
    
    public ArgScanner(String[] args) {
        this.table = new Hashtable<String, String>();
        
        String name = "",
                value = "";
        for(int i = 0, length = args.length; i < length; i++) {
            
            if(0 == i%2 || 0 == i) {
                name = args[i];
            } else {
                value = args[i];
                table.put(name, value);
            }
            
        }
    }
    
    public Boolean checkValue(String name) {
        return this.table.containsKey(prefix+name);
    }
    
    public String getValue(String name) {
        return this.table.get(prefix+name);
    }
}
