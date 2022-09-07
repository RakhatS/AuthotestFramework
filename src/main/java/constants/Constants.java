package constants;

public class Constants {
    public static class TimeoutVariable{
       public static final int IMPLICIT_WAIT = 4;
        public static final int EXPLICIT_WAIT = 10;
    }
    public static class Urls{
        /*
        * ссылка MOOC ENU
        * */
        public static final String MOOC_ENU_HOME_PAGE = "https://mooc.enu.kz";
        /*
        * возможные страницы после авторизации
        * */
        public static final String []MOOC_ENU_AUTORIZATION_PAGES = {"https://mooc.enu.kz"};


        /*
        * Ссылка MySite ( тест сайт )
        * */
        public static final String MY_SITE_HOME_PAGE = "http://mytestsite";

        /*
         * возможные страницы после авторизации
         * */
        public static final String []MY_SITE_AUTORIZATION_PAGES = {"http://mytestsite/dashboard/","http://mytestsite/wp-admin/"};

    }
}
