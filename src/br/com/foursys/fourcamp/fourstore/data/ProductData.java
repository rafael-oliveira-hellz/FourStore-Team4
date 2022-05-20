package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData implements ProductInterfaceData {
	
		List<Object> ListProduct = new ArrayList<Object>();

		@Override
		public void save(Object product) {
			ListProduct.add(product);
			// TODO Auto-generated method stub

		}

		

		@Override
		public void delete(Object object) {
			Product product = new Product();
			for (int x = 0; x < ListProduct.size(); x++) {
				Product product2 = (Product) ListProduct.get(x);
				if (product2.getSku().equals(product.getSku())) {
					this.ListProduct.remove(x);
				}

			}
			// TODO Auto-generated method stub

		}

		
		public Object findBySku(String sku) {
			Object comeback = null;
			for (int x = 0; x < ListProduct.size(); x++) {
				Product product = (Product) ListProduct.get(x);
				if (product.getSku().equals(sku)) {
					comeback = product;
				}

			}
			return comeback;
		}

		@Override
		public List<Object> findAll() {
		
			// TODO Auto-generated method stub
			return ListProduct;
		}

	}


