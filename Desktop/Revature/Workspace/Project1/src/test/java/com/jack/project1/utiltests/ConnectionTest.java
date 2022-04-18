package com.jack.project1.utiltests;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jack.project1.utils.ConnUtil;

public class ConnectionTest {
	private static Connection conn = ConnUtil.getInstance();
	
	@Test
    void generate_connection() {
        Assertions.assertNotNull(conn);
    }
	
	@Test
	void test_singleton() {
		Connection conn2 = ConnUtil.getInstance();
        Assertions.assertEquals(conn,conn2);
    }
}
