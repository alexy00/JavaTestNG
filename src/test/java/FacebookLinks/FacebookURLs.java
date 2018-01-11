package FacebookLinks;

import org.testng.annotations.DataProvider;

public class FacebookURLs {

    @DataProvider(name="URLs")
    public Object[][] grtdata(){
        return new Object[][]{
                {"http://www.lifecellskin.com/ExclusiveOffer/index-nov-fb.php"}, //1
                {"http://www.lifecellskin.com/ExclusiveOffer/mobile/index-nov-fb.php"},//2
                {"http://www.lifecellskin.com/SpecialOffer/index-nov-fb.php"}, //3
                {"http://www.lifecellskin.com/SpecialOffer/mobile/index-nov-fb.php"}, //4

                {"http://www.lifecellskin.com/OfertaExclusiva/index-nov-fb.php"}, //5
                {"http://www.lifecellskin.com/OfertaExclusiva/mobile/index-nov-fb.php"},//6
                {"http://www.lifecellskin.com/es/index-nov-fb.php"}, //7
                {"http://www.lifecellskin.com/es/mobile/index-nov-fb.php"},//8

                {"http://www.lifecellskin.com/pt/mobile/index-nov-fb-pt.php"},//9
                {"http://www.lifecellskin.com/pt-men/mobile/index-nov-fb-pt.php"},//10

                {"http://www.lifecellskin.com/fr/index-nov-fb.php"}, //11
                {"http://www.lifecellskin.com/fr-men/index-nov-fb.php"}, //12
                {"http://www.lifecellskin.com/fr/mobile/index-nov-fb.php"}, //13
                {"http://www.lifecellskin.com/fr-men/mobile/index-nov-fb.php"}, //14

                {"http://www.lifecellskin.com/es-sp/mobile/index-nov-fb.php"}, //15
                {"http://www.lifecellskin.com/es-sp-men/mobile/index-nov-fb.php"}, //16
                {"http://www.lifecellskin.com/es-sp/index-nov-fb.php"}, //17
                {"http://www.lifecellskin.com/es-sp-men/index-nov-fb.php"},  //18

        };
    }
}
