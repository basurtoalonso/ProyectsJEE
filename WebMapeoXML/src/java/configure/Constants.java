package configure;

public class Constants {
    
    public static final String ATTR_DIR_INCLUDES = "/CFS3-war/resources";
    public static final String ATTR_DIR_IMAGES = ATTR_DIR_INCLUDES + "/images/";
    public static final String ATTR_DIR_IMAGES_MENU = ATTR_DIR_IMAGES+"menu/";
    public static final String ATTR_DIR_CSS = ATTR_DIR_INCLUDES + "/css/";
    public static final String ATTR_DIR_JS = ATTR_DIR_INCLUDES+"/js/"; 
    public static final String ATTR_DIR_ERR = ATTR_DIR_INCLUDES+"/error/"; 
    
    public static final String ATTR_CURRENT_USER = "current.user";

    public String getATTR_CURRENT_USER_FUNC()
    {
        return ATTR_CURRENT_USER;
    }
    
}
