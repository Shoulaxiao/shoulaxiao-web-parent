package transaction;


import BaseAppTest2.BaseAppTest;
import com.shoulaxiao.bookweb.biz.UserBizService;
import org.junit.Test;

import javax.annotation.Resource;

public class TransactionTest extends BaseAppTest {

    @Resource
    private UserBizService userBizService;

    @Test
    public void insertA(){
        userBizService.testTransaction();
    }
}
