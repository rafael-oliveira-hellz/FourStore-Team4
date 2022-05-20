package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData implements ProductInterfaceData {
	
		List<Product> ListProduct = new ArrayList<Product>();

		@Override
		public Product save(Product product) {
			ListProduct.add(product);
			return product;

		}

		

		@Override
		public void deleteBySku(String sku) {
			for (int x = 0; x < ListProduct.size(); x++) {
				Product product = (Product) ListProduct.get(x);
				if (product.getSku().equals(sku)) {
					this.ListProduct.remove(x);
				}

			}
			// TODO Auto-generated method stub

		}

		
		public Product findBySku(String sku) {
			Product comeback = null;
			for (int x = 0; x < ListProduct.size(); x++) {
				Product product = (Product) ListProduct.get(x);
				if (product.getSku().equals(sku)) {
					comeback = product;
				}

			}
			return comeback;
		}

		@Override
		public List<Product> findAll() {
		
			// TODO Auto-generated method stub
			return ListProduct;
		}



	
		



		

	}


