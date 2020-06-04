package com.pig;

public class Rule {
 
    private String name;
        
      
    private String code;
    
   
    private boolean complex;

        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getCode() {
            return code;
        }
    
        public void setCode(String code) {
            this.code = code;
        }
    
        public boolean isComplex() {
            return complex;
        }
    
        public void setComplex(boolean complex) {
            this.complex = complex;
        }
    
     
        public String toString() {
            return new StringBuilder()
                    .append("\n" +name)
                    .append("\n" +(code))
                    .append("\n" +complex)
                    .toString();
        }
        
    
    
}