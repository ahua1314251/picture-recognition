package pic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * ͼƬ�и����
 * 
 * @author Johnson
 * @version Friday June 10th, 2011
 */
public class CutImage {
	/**
	 * �и�ͼƬ
	 * 
	 * @param sourceFile
	 *            Դ�ļ�
	 * @param targetDir
	 *            �洢Ŀ¼
	 * @param width
	 *            ��Ƭ���
	 * @param height
	 *            ��Ƭ�߶�
	 * @return
	 * @throws Exception
	 */
	public ImageDto cut(File sourceFile, String targetDir, int width, int height)
			throws Exception {
		List<File> list = new ArrayList<File>();
		BufferedImage source = ImageIO.read(sourceFile);
		int sWidth = source.getWidth(); // ͼƬ���
		int sHeight = source.getHeight(); // ͼƬ�߶�
		if (sWidth >= width && sHeight >= height) {
			int cols = 0; // ������Ƭ����
			int rows = 0; // ������Ƭ����
			int eWidth = 0; // ĩ����Ƭ���
			int eHeight = 0; // ĩ����Ƭ�߶�
			if (sWidth % width == 0) {
				cols = sWidth / width;
			} else {
				eWidth = sWidth % width;
				cols = sWidth / width + 1;
			}
			if (sHeight % height == 0) {
				rows = sHeight / height;
			} else {
				eHeight = sHeight % height;
				rows = sHeight / height + 1;
			}
			String fileName = null;
			File file = new File(targetDir);
			if (!file.exists()) { // �洢Ŀ¼�����ڣ��򴴽�Ŀ¼
				file.mkdirs();
			}
			BufferedImage image = null;
			int cWidth = 0; // ��ǰ��Ƭ���
			int cHeight = 0; // ��ǰ��Ƭ�߶�
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					cWidth = getWidth(j, cols, eWidth, width);
					cHeight = getHeight(i, rows, eHeight, height);
					// x����,y����,���,�߶�
					image = source.getSubimage(j * width, i * height, cWidth,
							cHeight);
					fileName = targetDir + "/map_" + i + "_" + j + ".jpg";
					file = new File(fileName);
					System.out.println(file.getAbsolutePath());
					ImageIO.write(image, "JPEG", file);
					list.add(file);
				}
			}
		}
		return new ImageDto(sWidth, sHeight, list);
	}
	/**
	 * �и�ͼƬ
	 * 
	 * @param source
	 *            Դ�ļ�·��
	 * @param targetDir
	 *            �洢Ŀ¼
	 * @param width
	 *            ��Ƭ���
	 * @param height
	 *            ��Ƭ�߶�
	 * @return
	 * @throws Exception
	 */
	public ImageDto cut(String source, String targetDir, int width, int height)
			throws Exception {
		return cut(new File(source), targetDir, width, height);
	}
	/**
	 * ��ȡ��ǰ��Ƭ�Ŀ��
	 * 
	 * @param index
	 *            ��������
	 * @param cols
	 *            ������Ƭ����
	 * @param endWidth
	 *            ĩ����Ƭ���
	 * @param width
	 *            ��Ƭ���
	 * @return
	 */
	private int getWidth(int index, int cols, int endWidth, int width) {
		if (index == cols - 1) {
			if (endWidth != 0) {
				return endWidth;
			}
		}
		return width;
	}
	/**
	 * ��ȡ��ǰ��Ƭ�ĸ߶�
	 * 
	 * @param index
	 *            ��������
	 * @param rows
	 *            ������Ƭ����
	 * @param endHeight
	 *            ĩ����Ƭ�߶�
	 * @param height
	 *            ��Ƭ�߶�
	 * @return
	 */
	private int getHeight(int index, int rows, int endHeight, int height) {
		if (index == rows - 1) {
			if (endHeight != 0) {
				return endHeight;
			}
		}
		return height;
	}
}
