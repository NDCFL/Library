package top.cflwork.config;

public interface Constant {
    //演示系统账户
     String DEMO_ACCOUNT = "test";
    //自动去除表前缀
     String AUTO_REOMVE_PRE = "true";
    //停止计划任务
     String STATUS_RUNNING_STOP = "stop";
    //开启计划任务
     String STATUS_RUNNING_START = "start";
    //通知公告阅读状态-未读
     String OA_NOTIFY_READ_NO = "0";
    //通知公告阅读状态-已读
     int OA_NOTIFY_READ_YES = 1;
    //部门根节点id
     Long DEPT_ROOT_ID = 0l;
    //缓存方式
     String CACHE_TYPE_REDIS ="redis";

     String LOG_ERROR = "error";

     String UPLOAD_AVATAR="upload/avatar";
     String RES_PRE="http://library.com";
     String JWT_SECRET="7786df7fc3a34e26a61c034d5ec8245d";
     String TOKEN="token";//登录的请求令牌名称
     String PATH = "http://file.mykefang.com";
    interface JPUSH{
        String SOUND_1="sound.caf";
    }
    String XMLPARAMS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification>";
    interface BOOK{
        String BOOK="DLibsAPI/services/ReaderWS";
        String BOOKSEARCH = "DLibsAPI/services/AssetsWS";
        String BOOKINFO = "DLibsAPI/services/BibliosWS";
        String BOOKLIST = "DLibsAPI/services/AssetsWS";
        String BORROW="DLibsAPI/services/ReaderWS";
        String NEWBOOK = "DLibsAPI/services/AssetsWS";
    }
    
    
}
