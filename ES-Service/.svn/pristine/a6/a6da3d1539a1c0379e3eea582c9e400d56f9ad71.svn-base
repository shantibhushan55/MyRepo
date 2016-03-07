BEGIN                { STATE = "START" }

/xml version/               {  
                        print $0 > RESULT_FILE ;
                        next;
                     }

/<definitions/       { 
                        START_INDEX = index($0, "xmlns:s0=\"");
                        REST = substr($0, START_INDEX + length("xmlns:s0=\"") );
                        LENGTH = index(REST, "\"");
                        S0_NAMESPACE = sprintf("xmlns:s0=\"%s", substr(REST, 0, LENGTH));
                        
                        START_INDEX = index($0, "xmlns:xsd=\"");
                        REST = substr($0, START_INDEX + length("xmlns:xsd=\"") );
                        LENGTH = index(REST, "\"");
                        XSD_NAMESPACE = sprintf("xmlns:xsd=\"%s", substr(REST, 0, LENGTH));                     
                     }

/<xsd:schema/        {
                        STATE = "SCHEMA";
                        SCHEMA_END_INDEX = index($0,"schema") + length("schema");
                        print substr($0, 0, SCHEMA_END_INDEX), S0_NAMESPACE, XSD_NAMESPACE, 
                              substr($0,SCHEMA_END_INDEX,length($0)) >> RESULT_FILE ;
                        next;
                     }
         
/xsd:schema>/        {
                        print $0 >> RESULT_FILE ;
                        STATE = "TAIL";
                        next;
                     }
                     
STATE == "SCHEMA"    {
                        print $0 >> RESULT_FILE ;
                        next;
                     }
   
 
