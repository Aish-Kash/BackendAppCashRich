package com.cashrich.model;

import java.util.List;
import java.util.Map;

public class CryptoResponse {

	private Status status;
    private Map<String, CryptoData> data;

    // Getters and setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, CryptoData> getData() {
        return data;
    }

    public void setData(Map<String, CryptoData> data) {
        this.data = data;
    }

    public static class Status {
        private String timestamp;
        private int errorCode;
        private String errorMessage;
        private int elapsed;
        private int creditCount;
        private String notice;

        // Getters and setters
        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public int getElapsed() {
            return elapsed;
        }

        public void setElapsed(int elapsed) {
            this.elapsed = elapsed;
        }

        public int getCreditCount() {
            return creditCount;
        }

        public void setCreditCount(int creditCount) {
            this.creditCount = creditCount;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }

    public static class CryptoData {
        private int id;
        private String name;
        private String symbol;
        private String slug;
        private int numMarketPairs;
        private String dateAdded;
        private List<String> tags;
        private Long maxSupply;
        private double circulatingSupply;
        private double totalSupply;
        private int isActive;
        private boolean infiniteSupply;
        private Object platform;
        private int cmcRank;
        private int isFiat;
        private Object selfReportedCirculatingSupply;
        private Object selfReportedMarketCap;
        private Object tvlRatio;
        private String lastUpdated;
        private Map<String, Quote> quote;

        // Getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getNumMarketPairs() {
            return numMarketPairs;
        }

        public void setNumMarketPairs(int numMarketPairs) {
            this.numMarketPairs = numMarketPairs;
        }

        public String getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(String dateAdded) {
            this.dateAdded = dateAdded;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public Long getMaxSupply() {
            return maxSupply;
        }

        public void setMaxSupply(Long maxSupply) {
            this.maxSupply = maxSupply;
        }

        public double getCirculatingSupply() {
            return circulatingSupply;
        }

        public void setCirculatingSupply(double circulatingSupply) {
            this.circulatingSupply = circulatingSupply;
        }

        public double getTotalSupply() {
            return totalSupply;
        }

        public void setTotalSupply(double totalSupply) {
            this.totalSupply = totalSupply;
        }

        public int getIsActive() {
            return isActive;
        }

        public void setIsActive(int isActive) {
            this.isActive = isActive;
        }

        public boolean isInfiniteSupply() {
            return infiniteSupply;
        }

        public void setInfiniteSupply(boolean infiniteSupply) {
            this.infiniteSupply = infiniteSupply;
        }

        public Object getPlatform() {
            return platform;
        }

        public void setPlatform(Object platform) {
            this.platform = platform;
        }

        public int getCmcRank() {
            return cmcRank;
        }

        public void setCmcRank(int cmcRank) {
            this.cmcRank = cmcRank;
        }

        public int getIsFiat() {
            return isFiat;
        }

        public void setIsFiat(int isFiat) {
            this.isFiat = isFiat;
        }

        public Object getSelfReportedCirculatingSupply() {
            return selfReportedCirculatingSupply;
        }

        public void setSelfReportedCirculatingSupply(Object selfReportedCirculatingSupply) {
            this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
        }

        public Object getSelfReportedMarketCap() {
            return selfReportedMarketCap;
        }

        public void setSelfReportedMarketCap(Object selfReportedMarketCap) {
            this.selfReportedMarketCap = selfReportedMarketCap;
        }

        public Object getTvlRatio() {
            return tvlRatio;
        }

        public void setTvlRatio(Object tvlRatio) {
            this.tvlRatio = tvlRatio;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public Map<String, Quote> getQuote() {
            return quote;
        }

        public void setQuote(Map<String, Quote> quote) {
            this.quote = quote;
        }
    }

    public static class Quote {
        private double price;
        private double volume24h;
        private double volumeChange24h;
        private double percentChange1h;
        private double percentChange24h;
        private double percentChange7d;
        private double percentChange30d;
        private double percentChange60d;
        private double percentChange90d;
        private double marketCap;
        private double marketCapDominance;
        private double fullyDilutedMarketCap;
        private Object tvl;
        private String lastUpdated;

        // Getters and setters
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getVolume24h() {
            return volume24h;
        }

        public void setVolume24h(double volume24h) {
            this.volume24h = volume24h;
        }

        public double getVolumeChange24h() {
            return volumeChange24h;
        }

        public void setVolumeChange24h(double volumeChange24h) {
            this.volumeChange24h = volumeChange24h;
        }

        public double getPercentChange1h() {
            return percentChange1h;
        }

        public void setPercentChange1h(double percentChange1h) {
            this.percentChange1h = percentChange1h;
        }

        public double getPercentChange24h() {
            return percentChange24h;
        }

        public void setPercentChange24h(double percentChange24h) {
            this.percentChange24h = percentChange24h;
        }

        public double getPercentChange7d() {
            return percentChange7d;
        }

        public void setPercentChange7d(double percentChange7d) {
            this.percentChange7d = percentChange7d;
        }

        public double getPercentChange30d() {
            return percentChange30d;
        }

        public void setPercentChange30d(double percentChange30d) {
            this.percentChange30d = percentChange30d;
        }

        public double getPercentChange60d() {
            return percentChange60d;
        }

        public void setPercentChange60d(double percentChange60d) {
            this.percentChange60d = percentChange60d;
        }

        public double getPercentChange90d() {
            return percentChange90d;
        }

        public void setPercentChange90d(double percentChange90d) {
            this.percentChange90d = percentChange90d;
        }

        public double getMarketCap() {
            return marketCap;
        }

        public void setMarketCap(double marketCap) {
            this.marketCap = marketCap;
        }

        public double getMarketCapDominance() {
            return marketCapDominance;
        }

        public void setMarketCapDominance(double marketCapDominance) {
            this.marketCapDominance = marketCapDominance;
        }

        public double getFullyDilutedMarketCap() {
            return fullyDilutedMarketCap;
        }

        public void setFullyDilutedMarketCap(double fullyDilutedMarketCap) {
            this.fullyDilutedMarketCap = fullyDilutedMarketCap;
        }

        public Object getTvl() {
            return tvl;
        }

        public void setTvl(Object tvl) {
            this.tvl = tvl;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }
    }
}
