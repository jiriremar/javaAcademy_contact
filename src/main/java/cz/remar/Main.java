package cz.remar;

import cz.remar.Service.CRUDManager;
import cz.remar.db.DBContactService;

public class Main {
    public static void main(String[] args) {

        new CRUDManager().printOptions();

    }
}