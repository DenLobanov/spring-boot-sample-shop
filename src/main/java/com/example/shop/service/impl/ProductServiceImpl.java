package com.example.shop.service.impl;

import com.example.shop.entity.Category;
import com.example.shop.entity.Producer;
import com.example.shop.entity.Product;
import com.example.shop.exception.InternalServerErrorException;
import com.example.shop.form.SearchForm;
import com.example.shop.jdbc.JDBCUtils;
import com.example.shop.jdbc.ResultSetHandler;
import com.example.shop.jdbc.ResultSetHandlerFactory;
import com.example.shop.jdbc.SearchQuery;
import com.example.shop.service.ProductService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ProductServiceImpl implements ProductService {
    private static final ResultSetHandler<List<Product>> productsResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
    private final ResultSetHandler<List<Category>> categoryListResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.CATEGORY_RESULT_SET_HANDLER);
    private final ResultSetHandler<List<Producer>> producerListResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCER_RESULT_SET_HANDLER);
    private final ResultSetHandler<Integer> countResultSetHandler = ResultSetHandlerFactory.getCountResultSetHandler();

    private final DataSource dataSource;

    public ProductServiceImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> listAllProducts(int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from product p, producer pr, category c "
                    + "where c.id=p.id_category and pr.id=p.id_producer limit ? offset ?", productsResultSetHandler, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> listProductsByCategory(String categoryUrl, int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(c,
                    "select p.*, c.name as category, pr.name as producer from product p, category c, producer pr where c.url=? and pr.id=p.id_producer and c.id=p.id_category order by p.id limit ? offset ?",
                    productsResultSetHandler, categoryUrl, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Category> listAllCategories() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select * from category order by id", categoryListResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Producer> listAllProducers() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select * from producer order by name", producerListResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countAllProducts() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select count(*) from product", countResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countProductsByCategory(String categoryUrl) {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select count(p.*) from product p, category c where c.id=p.id_category and c.url=?", countResultSetHandler, categoryUrl);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> listProductsBySearchForm(SearchForm form, int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            SearchQuery sq = buildSearchQuery("p.*, c.name as category, pr.name as producer", form);
            sq.getSql().append(" order by p.id limit ? offset ?");
            sq.getParams().add(limit);
            sq.getParams().add(offset);
            return JDBCUtils.select(c, sq.getSql().toString(), productsResultSetHandler, sq.getParams().toArray());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    protected SearchQuery buildSearchQuery(String selectFields, SearchForm form) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select ");
        sql.append(selectFields).append(" from product p, category c, producer pr where pr.id=p.id_producer and c.id=p.id_category and (p.name ilike ? or p.description ilike ?)");
        params.add("%" + form.getQuery() + "%");
        params.add("%" + form.getQuery() + "%");
        JDBCUtils.populateSqlAndParams(sql, params, form.getCategories(), "c.id = ?");
        JDBCUtils.populateSqlAndParams(sql, params, form.getProducers(), "pr.id = ?");
        return new SearchQuery(sql, params);
    }

    @Override
    public int countProductsBySearchForm(SearchForm form) {
        try (Connection c = dataSource.getConnection()) {
            SearchQuery sq = buildSearchQuery("count(*)", form);
            return JDBCUtils.select(c, sq.getSql().toString(), countResultSetHandler, sq.getParams().toArray());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }
}
