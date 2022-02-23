package com.examplsss.demo.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ljt
 * @time: 2022/2/23 0023 10:06
 */
public class QrCodeUtil {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;



    public static byte[] createQRCode(int width, int height, String content) throws WriterException, IOException {

// 二维码基本参数设置

        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();

        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置编码字符集utf-8

        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 设置纠错等级L/M/Q/H,纠错等级越高越不易识别，当前设置等级为最高等级H

        hints.put(EncodeHintType.MARGIN, 0);// 可设置范围为0-10，但仅四个变化0 1(2) 3(4 5 6) 7(8 9 10)

// 生成图片类型为QRCode

        BarcodeFormat format = BarcodeFormat.QR_CODE;

// 创建位矩阵对象

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, format, width, height, hints);

// 设置位矩阵转图片的参数

//        MatrixToImageConfig config = new MatrixToImageConfig(Color.black.getRGB(), Color.white.getRGB());

// 位矩阵对象转流对象

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        writeToStream(bitMatrix, "png", os);

        return os.toByteArray();

    }


    public static void writeToStream(BitMatrix matrix, String format,
                                     OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }



    public static void main(String[] args) throws WriterException, IOException {

        byte[] b = createQRCode(100, 100, "http://47.97.75.223/image/aaa.jpg");

        OutputStream os = new FileOutputStream("E:\\bestme.png");

        os.write(b);

        os.close();

    }

}
