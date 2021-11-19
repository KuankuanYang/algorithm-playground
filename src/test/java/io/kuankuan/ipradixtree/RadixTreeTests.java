package io.kuankuan.ipradixtree;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kuankuan Yang
 * @date 2021-11-08 16:29
 */
public class RadixTreeTests {

    @Test
    public void testInsertAndSearch() throws UnknownHostException {
        IPv4RadixIntTree tr = new IPv4RadixIntTree();
        tr.put("10.0.0.0/1", 99);
        // 00001010 00000000 00000000 00000000
        // 10000000 00000000 00000000 00000000
        // 00000000 00000000 00000000 00000000
        tr.selectValue("10.0.0.5");
    }

    @Test
    public void testCidrInclusion() {
        IPv4RadixIntTree tr = new IPv4RadixIntTree(100);
        tr.put(0x0a000000, 0xffffff00, 42);
        tr.put(0x0a000000, 0xff000000, 69);

        assertEquals(tr.selectValue(0x0a202020), 69);
        assertEquals(tr.selectValue(0x0a000020), 42);
        assertEquals(tr.selectValue(0x0b010203), IPv4RadixIntTree.NO_VALUE);
    }

    @Test
    public void testRealistic() throws IOException {
        IPv4RadixIntTree tr = IPv4RadixIntTree.loadFromLocalFile("/Users/ykk/GitHub/algorithm-playground/src/test/resources/ip-test/ip-prefix-base.txt");
        BufferedReader br = new BufferedReader(new FileReader("/Users/ykk/GitHub/algorithm-playground/src/test/resources/ip-test/test-1.txt"));
        String l;
        int n = 0;
        while ((l = br.readLine()) != null) {
            String[] c = l.split("\t", -1);
            assertEquals(tr.selectValue(c[0]), Integer.parseInt(c[1]), "Mismatch in line #" + n);
            n++;
        }
        System.out.println(tr.size());
    }

    @Test
    public void testNginx() throws IOException {
        IPv4RadixIntTree tr = IPv4RadixIntTree.loadFromLocalFile("/Users/ykk/GitHub/algorithm-playground/src/test/resources/ip-test/ip-prefix-nginx.txt", true);
        BufferedReader br = new BufferedReader(new FileReader("/Users/ykk/GitHub/algorithm-playground/src/test/resources/ip-test/test-nginx.txt"));
        String l;
        int n = 0;
        while ((l = br.readLine()) != null) {
            String[] c = l.split("\t", -1);
            assertEquals(tr.selectValue(c[0]), Integer.parseInt(c[1]), "Mismatch in line #" + n);
            n++;
        }
        System.out.println(tr.size());
    }
}
