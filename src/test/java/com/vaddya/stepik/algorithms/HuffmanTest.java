package com.vaddya.stepik.algorithms;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HuffmanTest {

    @Test
    public void encodeOneChar() {
        String str = "a";
        Map<Character, String> tree = Huffman.tree(str);
        String encoded = Huffman.encode(str, tree);

        assertEquals(1, tree.size());
        assertTrue(tree.containsKey('a'));
        assertEquals("0", encoded);
    }


    @Test
    public void encodeString() {
        String str = "abacabad";
        Map<Character, String> tree = Huffman.tree(str);
        String encoded = Huffman.encode(str, tree);

        assertEquals(4, tree.size());
        assertTrue(tree.containsKey('d'));
        assertEquals("01001110100110", encoded);
    }

    @Test
    public void decodeOneChar() {
        String str = "0";
        Map<String, Character> tree = Map.of("0", 'a');
        String decoded = Huffman.decode(str, tree);

        assertEquals("a", decoded);
    }

    @Test
    public void decodeString() {
        String str = "01001100100111";
        Map<String, Character> tree = Map.of(
                "0", 'a',
                "10", 'b',
                "110", 'c',
                "111", 'd'
        );
        String decoded = Huffman.decode(str, tree);

        assertEquals("abacabad", decoded);
    }
}