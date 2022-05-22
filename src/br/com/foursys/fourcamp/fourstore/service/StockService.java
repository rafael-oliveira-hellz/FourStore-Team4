package br.com.foursys.fourcamp.fourstore.service;

public class StockService {

	/*
	
	private StockDataInterface StockInterfaceData;

    public StockService(StockDataInterface StockInterfaceData) {
        this.StockInterfaceData = StockInterfaceData;
    }
    
    public String createProductStock(Stock stock) {
        Product savedStock = getStock(stock);
        return createMessageResponse();
    }
    
    public List<Stock> listAll() {
        List<Stock> allProductsStocks = StockInterfaceData.findAll();
        return allProductsStocks;
    }
	
	public void validatePurchase (Product product, Stock stock, Integer quantidadeVendida) {
		if (quantidadeVendida > stock.get(product)) {
    		throw new StockInsufficientException();
    	} else {
    		deductFromStock(product, stock, quantidadeVendida);
    		lowStockWarning(product, stock);
    		highStockWarning(product, stock)
    	}
	}
	
	public String lowStockWarning (Product product, Stock stock) {
		if (stock.get(product) < 50) {
			return "Estoque baixo, favor repor imediatamente!";
		}
		}
		
	public String highStockWarning (Product product, Stock stock) {
		if (stock.get(product) > 100) {
			return "Estoque cheio, operação negada!";
			}
			}
	
	public void deductFromStock(Product product, Stock stock, Integer quantidadeVendida) {
		if (StockInterfaceData.findByProduct(product).equals(null)) {
    		throw new ProductNotFoundException(product.getSku);
    	} else {
    		stock.put(product, stock.get(product) - quantidadeVendida);
    	}	
	}
	
	private String createMessageResponse();
	
	private Stock getStock(Stock stock) {
        return StockInterfaceData.save(stock);
    }
	
	
	}*/
}
