package org.zerock.jdbcex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTest {

    @Test
    public void test1() throws Exception{

        int v1 = 10;
        int v2 = 10;
        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void connectTest() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver"); // JDBC 드라이버 클래스를 메모리상으로 로딩

        //java.sql 패키지의 Connection 인터페이스 타입의 변수
        Connection connection = DriverManager.getConnection( // 데이터베이스 내에 있는 여러 정보들을 통해서 데이터 베이스에 연결 시도
                "jdbc:mariadb://localhost:3307/webdb",
                "webuser",
                "webuser"
        );

        Assertions.assertNotNull(connection);

        connection.close(); // 연결 종료
    }
}
