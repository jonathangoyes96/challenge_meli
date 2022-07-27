package com.optic.challengemeli.data.model;

import java.util.ArrayList;

/*
 * CONTIENE LA INFORMACION DE UN PRODUCTO ENCONTRADO EN UNA BUSQUEDA -> "SearchResult"
 */
public class ProductResult {
    public String id;
    public String site_id;
    public String title;
    public long price;
    public Object sale_price;
    public String currency_id;
    public int available_quantity;
    public int sold_quantity;
    public String buying_mode;
    public String listing_type_id;
    public String condition;
    public String permalink;
    public String thumbnail;
    public String thumbnail_id;
    public boolean accepts_mercadopago;
    public Object original_price;
    public String category_id;
    public Object official_store_id;
    public String domain_id;
    public String catalog_product_id;
    public ArrayList<String> tags;
    public boolean catalog_listing;
    public boolean use_thumbnail_id;
    public Object offer_score;
    public Object offer_share;
    public Object match_score;
    public Object winner_item_id;
    public Object melicoin;
    public Object discounts;
    public int order_backend;
    public Shipping shipping;
    public Address address;
    public Installments installments;

    public ProductResult() {
    }

    public ProductResult(String id, String site_id, String title, int price, Object sale_price, String currency_id, int available_quantity, int sold_quantity, String buying_mode, String listing_type_id, String condition, String permalink, String thumbnail, String thumbnail_id, boolean accepts_mercadopago, Object original_price, String category_id, Object official_store_id, String domain_id, String catalog_product_id, ArrayList<String> tags, boolean catalog_listing, boolean use_thumbnail_id, Object offer_score, Object offer_share, Object match_score, Object winner_item_id, Object melicoin, Object discounts, int order_backend, Shipping shipping, Address address, Installments installments) {
        this.id = id;
        this.site_id = site_id;
        this.title = title;
        this.price = price;
        this.sale_price = sale_price;
        this.currency_id = currency_id;
        this.available_quantity = available_quantity;
        this.sold_quantity = sold_quantity;
        this.buying_mode = buying_mode;
        this.listing_type_id = listing_type_id;
        this.condition = condition;
        this.permalink = permalink;
        this.thumbnail = thumbnail;
        this.thumbnail_id = thumbnail_id;
        this.accepts_mercadopago = accepts_mercadopago;
        this.original_price = original_price;
        this.category_id = category_id;
        this.official_store_id = official_store_id;
        this.domain_id = domain_id;
        this.catalog_product_id = catalog_product_id;
        this.tags = tags;
        this.catalog_listing = catalog_listing;
        this.use_thumbnail_id = use_thumbnail_id;
        this.offer_score = offer_score;
        this.offer_share = offer_share;
        this.match_score = match_score;
        this.winner_item_id = winner_item_id;
        this.melicoin = melicoin;
        this.discounts = discounts;
        this.order_backend = order_backend;
        this.shipping = shipping;
        this.address = address;
        this.installments = installments;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object getSale_price() {
        return sale_price;
    }

    public void setSale_price(Object sale_price) {
        this.sale_price = sale_price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(int sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getBuying_mode() {
        return buying_mode;
    }

    public void setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode;
    }

    public String getListing_type_id() {
        return listing_type_id;
    }

    public void setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail_id() {
        return thumbnail_id;
    }

    public void setThumbnail_id(String thumbnail_id) {
        this.thumbnail_id = thumbnail_id;
    }

    public boolean isAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public Object getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Object original_price) {
        this.original_price = original_price;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Object getOfficial_store_id() {
        return official_store_id;
    }

    public void setOfficial_store_id(Object official_store_id) {
        this.official_store_id = official_store_id;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public String getCatalog_product_id() {
        return catalog_product_id;
    }

    public void setCatalog_product_id(String catalog_product_id) {
        this.catalog_product_id = catalog_product_id;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public boolean isCatalog_listing() {
        return catalog_listing;
    }

    public void setCatalog_listing(boolean catalog_listing) {
        this.catalog_listing = catalog_listing;
    }

    public boolean isUse_thumbnail_id() {
        return use_thumbnail_id;
    }

    public void setUse_thumbnail_id(boolean use_thumbnail_id) {
        this.use_thumbnail_id = use_thumbnail_id;
    }

    public Object getOffer_score() {
        return offer_score;
    }

    public void setOffer_score(Object offer_score) {
        this.offer_score = offer_score;
    }

    public Object getOffer_share() {
        return offer_share;
    }

    public void setOffer_share(Object offer_share) {
        this.offer_share = offer_share;
    }

    public Object getMatch_score() {
        return match_score;
    }

    public void setMatch_score(Object match_score) {
        this.match_score = match_score;
    }

    public Object getWinner_item_id() {
        return winner_item_id;
    }

    public void setWinner_item_id(Object winner_item_id) {
        this.winner_item_id = winner_item_id;
    }

    public Object getMelicoin() {
        return melicoin;
    }

    public void setMelicoin(Object melicoin) {
        this.melicoin = melicoin;
    }

    public Object getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Object discounts) {
        this.discounts = discounts;
    }

    public int getOrder_backend() {
        return order_backend;
    }

    public void setOrder_backend(int order_backend) {
        this.order_backend = order_backend;
    }
}
