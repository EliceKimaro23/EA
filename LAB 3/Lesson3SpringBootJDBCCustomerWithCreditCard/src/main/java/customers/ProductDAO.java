package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB() {

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        jdbcTemplate.update("DELETE from product", namedParameters);
        jdbcTemplate.update("DELETE from supplier", namedParameters);
    }

    //SAVING A PRODUCT IN THE DATABASE
    public void save(Product product) {
        Map<String, Object> nameParameters = new HashMap<String, Object>();
        nameParameters.put("productNumber", product.getProductNumber());
        nameParameters.put("name", product.getName());
        nameParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES(:productNumber, :name, :price)", nameParameters);

        Map<String, Object> namedParameterssp = new HashMap<String, Object>();
        namedParameterssp.put("name", product.getSupplier().getName());
        namedParameterssp.put("phone", product.getSupplier().getPhone());
        namedParameterssp.put("productNumber", product.getProductNumber());
        jdbcTemplate.update("INSERT INTO supplier VALUES(:name, :phone, :productNumber)", namedParameterssp);
    }


    //    FINDING A PRODUCT BY PRODUCT NUMBER
    public Product findByProductNumber(Integer productNumber) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE " + "productNumber =:productNumber ",
                namedParameters, (rs, rowNum) -> new Product(rs.getInt("productNumber"), rs.getString("name"),
                        rs.getDouble("price")));
        product.setSupplier(getSupplierForProduct(product.getProductNumber()));
        return product;
    }


    // FINDING THE PRODUCT BY NAME

    public List<Product> findByProductName(String name) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("name", name);
        String sql = String.format("SELECT * FROM product WHERE name = '%s'", name);
        List<Product> product = jdbcTemplate.query(sql,
                namedParameters, (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        return product;
    }

    //GETTING ALL PRODUCTS
    public List<Product> getAllProducts() {
        List<Product> products = jdbcTemplate.query("SELECT * FROM product", new HashMap<String, Product>(),
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        for (Product product : products) {
            product.setSupplier(getSupplierForProduct(product.getProductNumber()));
        }

        return products;
    }

    //REMOVING A PRODUCT WITH THE GIVEN PRODUCT NUMBER
    public void removeProduct(Integer productNumber) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
        jdbcTemplate.update("DELETE FROM PRODUCT WHERE productNumber -:productNumber", namedParameters);
        System.out.println("Product was deleted *****************");
//        jdbcTemplate.update("DELETE FROM SUPPLIER WHERE PRODUCTNUMBER =:productNumber ", namedParameters);
//        System.out.println("Product was deleted from supplier *****************");


    }

    Supplier getSupplierForProduct(Integer productNumber) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
        System.out.println(productNumber);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier  WHERE " + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Supplier(
                        rs.getString("name"),
                        rs.getString("phone")));


        return supplier;
    }

}







