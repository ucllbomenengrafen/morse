package domain;
// https://www.mathworks.com/content/dam/mathworks/mathworks-dot-com/moler/exm/chapters/morse.pdf

/**
 * A class to decode a morse sequence to the corresponding character
 */
public class Morse {
    BinaryTree<Character> morseTree;

    public Morse() {
        createMorseTree();
    }

    /**
     * Decodes the given morse sequence to its corresponding character
     */
    public char decodeSequence(String sequence) {
        char[] chars = sequence.toCharArray();
        if (!isValidSequence(chars))
            throw new IllegalArgumentException("No valid sequence of signals");
        return morseTree.followPath(convertSequenceToBooleans(chars));
    }

    /**
     * A valid morse sequence for one character consists of '-' and '.'
     */
    private boolean isValidSequence(char[] chars) {
        if (chars == null || chars.length == 0)
            return false;
        for (char c : chars
        ) {
            if (!isValidSignal(c))
                return false;
        }
        return true;
    }

    private boolean isValidSignal(char s) {
        return s == '-' || s == '.';
    }

    /**
     * Converts the given array of characters to an array of booleans
     * '-' is converted to true
     * '.' is converted to false
     */
    private boolean[] convertSequenceToBooleans(char[] chars) {
        boolean[] booleans = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            booleans[i] = chars[i] == '-';
        }
        return booleans;
    }


    /**
     * Creates the morse tree according to its definition
     * https://en.wikipedia.org/wiki/Morse_code#/media/File:Morse_code_tree3.png
     */
    private void createMorseTree() {
        BinaryTree<Character> h = new BinaryTree<>('H');
        BinaryTree<Character> v = new BinaryTree<>('V');
        BinaryTree<Character> s = new BinaryTree<>('S', h, v);

        BinaryTree<Character> f = new BinaryTree<>('F');
        BinaryTree<Character> u = new BinaryTree<>('H', f, null);

        BinaryTree<Character> i = new BinaryTree<>('I', s, u);

        BinaryTree<Character> l = new BinaryTree<>('L');
        BinaryTree<Character> r = new BinaryTree<>('R', l, null);

        BinaryTree<Character> p = new BinaryTree<>('P');
        BinaryTree<Character> j = new BinaryTree<>('J');
        BinaryTree<Character> w = new BinaryTree<>('W', p, j);

        BinaryTree<Character> a = new BinaryTree<>('A', r, w);
        BinaryTree<Character> e = new BinaryTree<>('E', i, a);

        BinaryTree<Character> b = new BinaryTree<>('B');
        BinaryTree<Character> x = new BinaryTree<>('X');
        BinaryTree<Character> d = new BinaryTree<>('D', b, x);

        BinaryTree<Character> c = new BinaryTree<>('C');
        BinaryTree<Character> y = new BinaryTree<>('Y');
        BinaryTree<Character> k = new BinaryTree<>('K', c, y);

        BinaryTree<Character> n = new BinaryTree<>('N', d, k);

        BinaryTree<Character> z = new BinaryTree<>('Z');
        BinaryTree<Character> q = new BinaryTree<>('Q');
        BinaryTree<Character> g = new BinaryTree<>('G', z, q);

        BinaryTree<Character> o = new BinaryTree<>('O');
        BinaryTree<Character> m = new BinaryTree<>('M', g, o);

        BinaryTree<Character> t = new BinaryTree<>('T', n, m);

        morseTree = new BinaryTree<>('0', e, t);
    }
}
