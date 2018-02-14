/**
 * 
 */
package com.projet.isidis.web.QR;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 
 * @date 2017-10-26
 * @author QU
 * 
 */
public class QRCodeFR {
	private static final int BLACK = 0xff000000;
	private static final int WHITE = 0xFFFFFFFF;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QRCodeFR test = new QRCodeFR();
		test.construireQR("1",1);
		test.construireQR("2",2);
		test.construireQR("3",3);
		test.construireQR("4",4);
		test.construireQR("5",5);
	}

	public void construireQR(String name,int id_table){
		String filePostfix="png";
		File file = new File("src\\main\\resources\\static\\images\\"+name+"."+filePostfix);
		//lien de android local
		//this.encode("http://192.168.0.19:8080/menus/3/"+id_table, file,filePostfix, BarcodeFormat.QR_CODE, 5000, 5000, null);
		//lien de web android
		this.encode("http://vps507764.ovh.net:8080/projet_isidis/menus/3/"+id_table, file,filePostfix, BarcodeFormat.QR_CODE, 5000, 5000, null);
		//lien de web soap
		//this.encode("http://vps507764.ovh.net:8080/projet_isidis/Menus/"+id_table, file,filePostfix, BarcodeFormat.QR_CODE, 5000, 5000, null);
		//lien de soap local
		//this.encode("http://192.168.0.19:8080/Menus/"+id_table, file,filePostfix, BarcodeFormat.QR_CODE, 5000, 5000, null);
	}

	/**
	 *  créé QRCode<br> 
	 * @param contents le contenu du QR code
	 * @param file chemin de conserver，par exemple ：C://test_QR_CODE.png
	 * @param filePostfix png,jpeg,gif etc
	 * @param format qrcode 
	 * @param width large
	 * @param height haut 
	 * @param hints
	 */
	public void encode(String contents, File file,String filePostfix, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) {
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, format, width, height);
			writeToFile(bitMatrix, filePostfix, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Création une photo QR code <br>
	 * 
	 * @param matrix
	 * @param format
	 *            format de la photo
	 * @param file
	 *            chemin de QR
	 * @throws IOException
	 */
	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		ImageIO.write(image, format, file);
	}

	/**
	 * Création un QR code<br>
	 * 
	 * @param matrix
	 * @return
	 */
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
			}
		}
		return image;
	}

	/**
	 * ANALYSER QRCode
	 */
	@SuppressWarnings("unchecked")
	public void decode(File file) {
		try {
			BufferedImage image;
			try {
				image = ImageIO.read(file);
				if (image == null) {
					System.out.println("Could not decode image");
				}
				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
				Result result;
				@SuppressWarnings("rawtypes")
				Hashtable hints = new Hashtable();
				hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
				result = new MultiFormatReader().decode(bitmap, hints);
				String resultStr = result.getText();
				System.out.println("Après le contenu d'analytique：" + resultStr);
			} catch (IOException ioe) {
				System.out.println(ioe.toString());
			} catch (ReaderException re) {
				System.out.println(re.toString());
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
