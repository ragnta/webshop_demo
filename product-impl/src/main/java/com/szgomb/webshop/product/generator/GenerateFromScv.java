package com.szgomb.webshop.product.generator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.stream.Stream;

import com.szgom.webshop.product.model.Product;

public class GenerateFromScv {

	private final static String DEMO_DATA = """
Samsung Galaxy S21,Powerful smartphone from Samsung,849.99,https://picsum.photos/id/1071/300/200,10
Bose QuietComfort 35 II,Wireless noise-cancelling headphones,299.99,https://picsum.photos/id/1084/300/200,5
Canon EOS R6,Mirrorless camera with full-frame sensor,2399.99,https://picsum.photos/id/1060/300/200,2
Nike Air Zoom Pegasus 38,Running shoes with responsive foam,119.99,https://picsum.photos/id/1035/300/200,8
Apple iPad Air (2020),Powerful and portable tablet from Apple,599.99,https://picsum.photos/id/1022/300/200,3
Dell XPS 13,High-end laptop with stunning display,1499.99,https://picsum.photos/id/1020/300/200,1
LG OLED CX Series,55-inch 4K OLED TV with stunning picture quality,1499.99,https://picsum.photos/id/1047/300/200,2
Google Nest Hub (2nd gen),Smart display with Google Assistant,99.99,https://picsum.photos/id/1019/300/200,4
Sony WH-1000XM4,Wireless noise-cancelling headphones,349.99,https://picsum.photos/id/1062/300/200,7
Garmin Fenix 6,Advanced GPS smartwatch for outdoor adventures,799.99,https://picsum.photos/id/1025/300/200,2
Microsoft Surface Pro 7,Powerful and versatile tablet from Microsoft,899.99,https://picsum.photos/id/1073/300/200,4
JBL Flip 5,Portable waterproof Bluetooth speaker,119.99,https://picsum.photos/id/1032/300/200,6
Samsung Q90T,QLED TV with stunning picture quality,1999.99,https://picsum.photos/id/1081/300/200,3
Fitbit Charge 4,Advanced fitness tracker with GPS,149.99,https://picsum.photos/id/1068/300/200,9
Anker PowerCore 10000,Compact and portable power bank,29.99,https://picsum.photos/id/1011/300/200,12
						""";
	private static final String template = """
			<insert tableName="PRODUCT">
			       <column name="name" value="PROD_NAME"/>
			       <column name="description" value="DESC_DET"/>
			       <column name="price" value="PRICE_DET"/>
			       <column name="imgUrl" value="IMGURL_DET"/>
			       <column name="quantity" value="QUAN_DET"/>
			 </insert>
			""";

	private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

	public static void main(String[] args) {
		Stream.of(DEMO_DATA.split("\n")).map(line -> {
			String[] split = line.split(",");
			try {
				return Product.builder().name(split[0]).description(split[1])
						.price(BigDecimal.valueOf((Double) decimalFormat.parse(split[2]))).imgUrl(split[3])
						.quantity(Integer.valueOf(split[4])).build();

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).forEach(product -> {
			String insert = template.replace("PROD_NAME", product.getName()).replace("DESC_DET", product.getDescription())
					.replace("PRICE_DET", product.getPrice().toPlainString()).replace("IMGURL_DET", product.getImgUrl())
					.replace("QUAN_DET", product.getQuantity().toString());
			System.out.println(insert);
		});

	}

}
