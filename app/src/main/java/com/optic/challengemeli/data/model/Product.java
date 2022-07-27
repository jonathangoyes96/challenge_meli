package com.optic.challengemeli.data.model;

import java.util.ArrayList;
import java.util.Date;

/*
 * CONTIENE LA INFORMACION DEL DETALLE DE UN PRODUCTO
 */
public class Product{
    public String id;
    public String site_id;
    public String title;
    public Object subtitle;
    public int seller_id;
    public String category_id;
    public Object official_store_id;
    public long price;
    public long base_price;
    public Object original_price;
    public String currency_id;
    public int initial_quantity;
    public int available_quantity;
    public int sold_quantity;
    public String buying_mode;
    public String listing_type_id;
    public Date start_time;
    public Date stop_time;
    public String condition;
    public String permalink;
    public String thumbnail_id;
    public String thumbnail;
    public String secure_thumbnail;
    public ArrayList<Picture> pictures;
    public Object video_id;
    public ArrayList<Object> descriptions;
    public boolean accepts_mercadopago;
    public ArrayList<Object> non_mercado_pago_payment_methods;
    public Shipping shipping;
    public String international_delivery_mode;
    public Object seller_contact;
    public ArrayList<Object> coverage_areas;
    public ArrayList<Attribute> attributes;
    public ArrayList<Object> warnings;
    public String listing_source;
    public ArrayList<Object> variations;
    public String status;
    public ArrayList<Object> sub_status;
    public ArrayList<String> tags;
    public String warranty;
    public String catalog_product_id;
    public String domain_id;
    public Object parent_item_id;
    public Object differential_pricing;
    public ArrayList<Object> deal_ids;
    public boolean automatic_relist;
    public Date date_created;
    public Date last_updated;
    public Object health;
    public boolean catalog_listing;
    public ArrayList<String> channels;


    public Product() {
    }

    public Product(String id, String site_id, String title, Object subtitle, int seller_id, String category_id, Object official_store_id, long price, long base_price, Object original_price, String currency_id, int initial_quantity, int available_quantity, int sold_quantity, String buying_mode, String listing_type_id, Date start_time, Date stop_time, String condition, String permalink, String thumbnail_id, String thumbnail, String secure_thumbnail, ArrayList<Picture> pictures, Object video_id, ArrayList<Object> descriptions, boolean accepts_mercadopago, ArrayList<Object> non_mercado_pago_payment_methods, Shipping shipping, String international_delivery_mode, Object seller_contact, ArrayList<Object> coverage_areas, ArrayList<Attribute> attributes, ArrayList<Object> warnings, String listing_source, ArrayList<Object> variations, String status, ArrayList<Object> sub_status, ArrayList<String> tags, String warranty, String catalog_product_id, String domain_id, Object parent_item_id, Object differential_pricing, ArrayList<Object> deal_ids, boolean automatic_relist, Date date_created, Date last_updated, Object health, boolean catalog_listing, ArrayList<String> channels) {
        this.id = id;
        this.site_id = site_id;
        this.title = title;
        this.subtitle = subtitle;
        this.seller_id = seller_id;
        this.category_id = category_id;
        this.official_store_id = official_store_id;
        this.price = price;
        this.base_price = base_price;
        this.original_price = original_price;
        this.currency_id = currency_id;
        this.initial_quantity = initial_quantity;
        this.available_quantity = available_quantity;
        this.sold_quantity = sold_quantity;
        this.buying_mode = buying_mode;
        this.listing_type_id = listing_type_id;
        this.start_time = start_time;
        this.stop_time = stop_time;
        this.condition = condition;
        this.permalink = permalink;
        this.thumbnail_id = thumbnail_id;
        this.thumbnail = thumbnail;
        this.secure_thumbnail = secure_thumbnail;
        this.pictures = pictures;
        this.video_id = video_id;
        this.descriptions = descriptions;
        this.accepts_mercadopago = accepts_mercadopago;
        this.non_mercado_pago_payment_methods = non_mercado_pago_payment_methods;
        this.shipping = shipping;
        this.international_delivery_mode = international_delivery_mode;
        this.seller_contact = seller_contact;
        this.coverage_areas = coverage_areas;
        this.attributes = attributes;
        this.warnings = warnings;
        this.listing_source = listing_source;
        this.variations = variations;
        this.status = status;
        this.sub_status = sub_status;
        this.tags = tags;
        this.warranty = warranty;
        this.catalog_product_id = catalog_product_id;
        this.domain_id = domain_id;
        this.parent_item_id = parent_item_id;
        this.differential_pricing = differential_pricing;
        this.deal_ids = deal_ids;
        this.automatic_relist = automatic_relist;
        this.date_created = date_created;
        this.last_updated = last_updated;
        this.health = health;
        this.catalog_listing = catalog_listing;
        this.channels = channels;
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

    public Object getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Object subtitle) {
        this.subtitle = subtitle;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getBase_price() {
        return base_price;
    }

    public void setBase_price(long base_price) {
        this.base_price = base_price;
    }

    public Object getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Object original_price) {
        this.original_price = original_price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getInitial_quantity() {
        return initial_quantity;
    }

    public void setInitial_quantity(int initial_quantity) {
        this.initial_quantity = initial_quantity;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getStop_time() {
        return stop_time;
    }

    public void setStop_time(Date stop_time) {
        this.stop_time = stop_time;
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

    public String getThumbnail_id() {
        return thumbnail_id;
    }

    public void setThumbnail_id(String thumbnail_id) {
        this.thumbnail_id = thumbnail_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSecure_thumbnail() {
        return secure_thumbnail;
    }

    public void setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail;
    }

    public ArrayList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        this.pictures = pictures;
    }

    public Object getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Object video_id) {
        this.video_id = video_id;
    }

    public ArrayList<Object> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(ArrayList<Object> descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public ArrayList<Object> getNon_mercado_pago_payment_methods() {
        return non_mercado_pago_payment_methods;
    }

    public void setNon_mercado_pago_payment_methods(ArrayList<Object> non_mercado_pago_payment_methods) {
        this.non_mercado_pago_payment_methods = non_mercado_pago_payment_methods;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getInternational_delivery_mode() {
        return international_delivery_mode;
    }

    public void setInternational_delivery_mode(String international_delivery_mode) {
        this.international_delivery_mode = international_delivery_mode;
    }

    public Object getSeller_contact() {
        return seller_contact;
    }

    public void setSeller_contact(Object seller_contact) {
        this.seller_contact = seller_contact;
    }

    public ArrayList<Object> getCoverage_areas() {
        return coverage_areas;
    }

    public void setCoverage_areas(ArrayList<Object> coverage_areas) {
        this.coverage_areas = coverage_areas;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<Object> warnings) {
        this.warnings = warnings;
    }

    public String getListing_source() {
        return listing_source;
    }

    public void setListing_source(String listing_source) {
        this.listing_source = listing_source;
    }

    public ArrayList<Object> getVariations() {
        return variations;
    }

    public void setVariations(ArrayList<Object> variations) {
        this.variations = variations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Object> getSub_status() {
        return sub_status;
    }

    public void setSub_status(ArrayList<Object> sub_status) {
        this.sub_status = sub_status;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getCatalog_product_id() {
        return catalog_product_id;
    }

    public void setCatalog_product_id(String catalog_product_id) {
        this.catalog_product_id = catalog_product_id;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public Object getParent_item_id() {
        return parent_item_id;
    }

    public void setParent_item_id(Object parent_item_id) {
        this.parent_item_id = parent_item_id;
    }

    public Object getDifferential_pricing() {
        return differential_pricing;
    }

    public void setDifferential_pricing(Object differential_pricing) {
        this.differential_pricing = differential_pricing;
    }

    public ArrayList<Object> getDeal_ids() {
        return deal_ids;
    }

    public void setDeal_ids(ArrayList<Object> deal_ids) {
        this.deal_ids = deal_ids;
    }

    public boolean isAutomatic_relist() {
        return automatic_relist;
    }

    public void setAutomatic_relist(boolean automatic_relist) {
        this.automatic_relist = automatic_relist;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public Object getHealth() {
        return health;
    }

    public void setHealth(Object health) {
        this.health = health;
    }

    public boolean isCatalog_listing() {
        return catalog_listing;
    }

    public void setCatalog_listing(boolean catalog_listing) {
        this.catalog_listing = catalog_listing;
    }

    public ArrayList<String> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels = channels;
    }
}