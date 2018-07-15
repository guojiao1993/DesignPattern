package decorator.io;

import java.io.*;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		try {
            InputStream is = InputTest.class.getClassLoader().getResourceAsStream("decorator/io/test.txt");
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(is));
			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}