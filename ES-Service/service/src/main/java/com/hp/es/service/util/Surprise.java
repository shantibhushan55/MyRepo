package com.hp.es.service.util;

import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.sif.SifException;

public class Surprise {

    public static void check(EntitlementBySnRequest request) throws SifException {

        if ( request != null && "ES".equals(request.getProductID()) &&
             "TEAM".equals(request.getSerialNumber()) ) {

            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,

            "\n\nThe ES SOLAR Release has been brought to you by (in alphabetical order):\n\n" +
            "Angelika Nuessle - Project Management ---\n" +
            "Antoine Voiry - Design ---\n" +
            "Birgit Neumann - Design ---\n" +
            "Frank Renftle - Analysis ---\n" +
            "Frank Schrade - Analysis ---\n" +
            "Juan Gonzalez- System Test Management ---\n" +
            "Juergen Hanke - ALURPS testing ---\n" +
            "Laslo Bednarik - Design ---\n" +
            "Michael Kaluza - ES Development Manager ---\n" +
            "Philippe Eckert - Analysis, Architecture ---\n" +
            "Steffen Sobe - Design ---\n\n\n"

            );

        }

    }
}