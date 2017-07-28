package leetcode;

package com.qiniu.storage;

        import com.qiniu.common.QiniuException;
        import com.qiniu.http.Client;
        import com.qiniu.http.Response;
        import com.qiniu.storage.model.FetchRet;
        import com.qiniu.storage.model.FileInfo;
        import com.qiniu.storage.model.FileListing;
        import com.qiniu.util.Auth;
        import com.qiniu.util.StringMap;
        import com.qiniu.util.StringUtils;
        import com.qiniu.util.UrlSafeBase64;

        import java.util.ArrayList;
        import java.util.Iterator;

/**
 * 涓昏娑夊強浜嗙┖闂磋祫婧愮鐞嗗強鎵归噺鎿嶄綔鎺ュ彛鐨勫疄鐜帮紝鍏蜂綋鐨勬帴鍙ｈ鏍煎彲浠ュ弬鑰�
 * 鍙傝�冩枃妗ｏ細<a href="http://developer.qiniu.com/kodo/api/rs">璧勬簮绠＄悊</a>
 */
public final class BucketManager {
    /**
     * Auth 瀵硅薄
     * 璇ョ被闇�瑕佷娇鐢≦Box閴存潈锛屾墍浠ラ渶瑕佹寚瀹欰uth瀵硅薄
     */
    private final Auth auth;

    /**
     * Configuration 瀵硅薄
     * 璇ョ被鐩稿叧鐨勫煙鍚嶉厤缃紝瑙ｆ瀽閰嶇疆锛孒TTP璇锋眰瓒呮椂鏃堕棿璁剧疆绛�
     */

    private final Configuration configuration;

    /**
     * HTTP Client 瀵硅薄
     * 璇ョ被闇�瑕侀�氳繃璇ュ璞℃潵鍙戦�丠TTP璇锋眰
     */
    private final Client client;

    /**
     * 鏋勫缓涓�涓柊鐨� BucketManager 瀵硅薄
     *
     * @param auth Auth瀵硅薄
     * @param cfg  Configuration瀵硅薄
     */
    public BucketManager(Auth auth, Configuration cfg) {
        this.auth = auth;
        this.configuration = cfg.clone();
        client = new Client(this.configuration);
    }

    /**
     * EncodedEntryURI鏍煎紡锛屽叾涓� bucket+":"+key 绉颁箣涓� entry
     *
     * @param bucket
     * @param key
     * @return UrlSafeBase64.encodeToString(entry)
     * @link http://developer.qiniu.com/kodo/api/data-format
     */
    public static String encodedEntry(String bucket, String key) {
        String encodedEntry;
        if (key != null) {
            encodedEntry = UrlSafeBase64.encodeToString(bucket + ":" + key);
        } else {
            encodedEntry = UrlSafeBase64.encodeToString(bucket);
        }
        return encodedEntry;
    }

    /**
     * EncodedEntryURI鏍煎紡锛岀敤鍦ㄤ笉鎸囧畾key鍊肩殑鎯呭喌涓�
     *
     * @param bucket 绌洪棿鍚嶇О
     * @return UrlSafeBase64.encodeToString(bucket)
     * @link http://developer.qiniu.com/kodo/api/data-format
     */
    public static String encodedEntry(String bucket) {
        return encodedEntry(bucket, null);
    }


    /**
     * 鑾峰彇璐﹀彿涓嬫墍鏈夌┖闂村悕绉板垪琛�
     *
     * @return 绌洪棿鍚嶇О鍒楄〃
     */
    public String[] buckets() throws QiniuException {
        // 鑾峰彇 bucket 鍒楄〃 鍐欐鐢╮s.qiniu.com or rs.qbox.me @鍐珛鍏�
        String url = String.format("%s/buckets", configuration.rsHost());
        Response r = get(url);
        return r.jsonToObject(String[].class);
    }

    /**
     * 鑾峰彇璇ョ┖闂翠笅鎵�鏈夌殑domain
     *
     * @param bucket
     * @return 璇ョ┖闂村悕涓嬬殑domain
     * @throws QiniuException
     */

    public String[] domainList(String bucket) throws QiniuException {
        String url = String.format("%s/v6/domain/list?tbl=%s", "http://api.qiniu.com", bucket);
        Response r = get(url);
        return r.jsonToObject(String[].class);
    }

    /**
     * 鏍规嵁鍓嶇紑鑾峰彇鏂囦欢鍒楄〃鐨勮凯浠ｅ櫒
     *
     * @param bucket 绌洪棿鍚�
     * @param prefix 鏂囦欢鍚嶅墠缂�
     * @return FileInfo杩唬鍣�
     */
    public FileListIterator createFileListIterator(String bucket, String prefix) {
        return new FileListIterator(bucket, prefix, 1000, null);
    }

    /**
     * 鏍规嵁鍓嶇紑鑾峰彇鏂囦欢鍒楄〃鐨勮凯浠ｅ櫒
     *
     * @param bucket    绌洪棿鍚�
     * @param prefix    鏂囦欢鍚嶅墠缂�
     * @param limit     姣忔杩唬鐨勯暱搴﹂檺鍒讹紝鏈�澶�1000锛屾帹鑽愬�� 100
     * @param delimiter 鎸囧畾鐩綍鍒嗛殧绗︼紝鍒楀嚭鎵�鏈夊叕鍏卞墠缂�锛堟ā鎷熷垪鍑虹洰褰曟晥鏋滐級銆傜己鐪佸�间负绌哄瓧绗︿覆
     * @return FileInfo杩唬鍣�
     */
    public FileListIterator createFileListIterator(String bucket, String prefix, int limit, String delimiter) {
        return new FileListIterator(bucket, prefix, limit, delimiter);
    }

    /**
     * 鏍规嵁鍓嶇紑鑾峰彇鏂囦欢鍒楄〃
     *
     * @param bucket    绌洪棿鍚�
     * @param prefix    鏂囦欢鍚嶅墠缂�
     * @param marker    涓婁竴娆¤幏鍙栨枃浠跺垪琛ㄦ椂杩斿洖鐨� marker
     * @param limit     姣忔杩唬鐨勯暱搴﹂檺鍒讹紝鏈�澶�1000锛屾帹鑽愬�� 100
     * @param delimiter 鎸囧畾鐩綍鍒嗛殧绗︼紝鍒楀嚭鎵�鏈夊叕鍏卞墠缂�锛堟ā鎷熷垪鍑虹洰褰曟晥鏋滐級銆傜己鐪佸�间负绌哄瓧绗︿覆
     * @return
     * @throws QiniuException
     */
    public FileListing listFiles(String bucket, String prefix, String marker, int limit, String delimiter)
            throws QiniuException {
        StringMap map = new StringMap().put("bucket", bucket).putNotEmpty("marker", marker)
                .putNotEmpty("prefix", prefix).putNotEmpty("delimiter", delimiter).putWhen("limit", limit, limit > 0);

        String url = String.format("%s/list?%s", configuration.rsfHost(auth.accessKey, bucket), map.formString());
        Response r = get(url);
        return r.jsonToObject(FileListing.class);
    }

    /**
     * 鑾峰彇绌洪棿涓枃浠剁殑灞炴��
     *
     * @param bucket  绌洪棿鍚嶇О
     * @param fileKey 鏂囦欢鍚嶇О
     * @return 鏂囦欢灞炴��
     * @throws QiniuException
     * @link http://developer.qiniu.com/kodo/api/stat
     */
    public FileInfo stat(String bucket, String fileKey) throws QiniuException {
        Response r = rsGet(bucket, String.format("/stat/%s", encodedEntry(bucket, fileKey)));
        return r.jsonToObject(FileInfo.class);
    }

    /**
     * 鍒犻櫎鎸囧畾绌洪棿銆佹枃浠跺悕鐨勬枃浠�
     *
     * @param bucket 绌洪棿鍚嶇О
     * @param key    鏂囦欢鍚嶇О
     * @throws QiniuException
     * @link http://developer.qiniu.com/kodo/api/delete
     */
    public Response delete(String bucket, String key) throws QiniuException {
        return rsPost(bucket, String.format("/delete/%s", encodedEntry(bucket, key)), null);
    }

    /**
     * 淇敼鏂囦欢鐨凪imeType
     *
     * @param bucket 绌洪棿鍚嶇О
     * @param key    鏂囦欢鍚嶇О
     * @param mime   鏂囦欢鐨勬柊MimeType
     * @throws QiniuException
     * @link http://developer.qiniu.com/kodo/api/chgm
     */
    public Response changeMime(String bucket, String key, String mime)
            throws QiniuException {
        String resource = encodedEntry(bucket, key);
        String encodedMime = UrlSafeBase64.encodeToString(mime);
        String path = String.format("/chgm/%s/mime/%s", resource, encodedMime);
        return rsPost(bucket, path, null);
    }


    //瀛樺偍绫诲瀷
    enum StorageType {
        //鏅�氬瓨鍌�
        COMMON,
        //浣庨瀛樺偍
        INFREQUENCY
    }

    /**
     * 淇敼鏂囦欢鐨勭被鍨嬶紙鏅�氬瓨鍌ㄦ垨浣庨瀛樺偍锛�
     *
     * @param bucket 绌洪棿鍚嶇О
     * @param key    鏂囦欢鍚嶇О
     * @param type   type=0 琛ㄧず鏅�氬瓨鍌紝type=1 琛ㄧず浣庨瀛樺瓨鍌�
     * @throws QiniuException
     */
    public Response changeType(String bucket, String key, StorageType type)
            throws QiniuException {
        String resource = encodedEntry(bucket, key);
        String path = String.format("/chtype/%s/type/%d", resource, type.ordinal());
        return rsPost(bucket, path, null);
    }

    /**
     * 閲嶅懡鍚嶇┖闂翠腑鐨勬枃浠讹紝鍙互璁剧疆force鍙傛暟涓簍rue寮鸿瑕嗙洊绌洪棿宸叉湁鍚屽悕鏂囦欢
     *
     * @param bucket     绌洪棿鍚嶇О
     * @param oldFileKey 鏂囦欢鍚嶇О
     * @param newFileKey 鏂版枃浠跺悕
     * @param force      寮哄埗瑕嗙洊绌洪棿涓凡鏈夊悓鍚嶏紙鍜� newFileKey 鐩稿悓锛夌殑鏂囦欢
     * @throws QiniuException
     */
    public Response rename(String bucket, String oldFileKey, String newFileKey, boolean force)
            throws QiniuException {
        return move(bucket, oldFileKey, bucket, newFileKey, force);
    }

    /**
     * 閲嶅懡鍚嶇┖闂翠腑鐨勬枃浠�
     *
     * @param bucket     绌洪棿鍚嶇О
     * @param oldFileKey 鏂囦欢鍚嶇О
     * @param newFileKey 鏂版枃浠跺悕
     * @throws QiniuException
     * @link http://developer.qiniu.com/kodo/api/move
     */
    public Response rename(String bucket, String oldFileKey, String newFileKey)
            throws QiniuException {
        return move(bucket, oldFileKey, bucket, newFileKey);
    }

    /**
     * 澶嶅埗鏂囦欢锛岃姹傜┖闂村湪鍚屼竴璐﹀彿涓嬶紝鍙互璁剧疆force鍙傛暟涓簍rue寮鸿瑕嗙洊绌洪棿宸叉湁鍚屽悕鏂囦欢
     *
     * @param fromBucket  婧愮┖闂村悕绉�
     * @param fromFileKey 婧愭枃浠跺悕绉�
     * @param toBucket    鐩殑绌洪棿鍚嶇О
     * @param toFileKey   鐩殑鏂囦欢鍚嶇О
     * @param force       寮哄埗瑕嗙洊绌洪棿涓凡鏈夊悓鍚嶏紙鍜� toFileKey 鐩稿悓锛夌殑鏂囦欢
     * @throws QiniuException
     */
    public Response copy(String fromBucket, String fromFileKey, String toBucket, String toFileKey, boolean force)
            throws QiniuException {
        String from = encodedEntry(fromBucket, fromFileKey);
        String to = encodedEntry(toBucket, toFileKey);
        String path = String.format("/copy/%s/%s/force/%s", from, to, force);
        return rsPost(fromBucket, path, null);
    }

    /**
     * 澶嶅埗鏂囦欢锛岃姹傜┖闂村湪鍚屼竴璐﹀彿涓�
     *
     * @param fromBucket  婧愮┖闂村悕绉�
     * @param fromFileKey 婧愭枃浠跺悕绉�
     * @param toBucket    鐩殑绌洪棿鍚嶇О
     * @param toFileKey   鐩殑鏂囦欢鍚嶇О
     * @throws QiniuException
     */
    public void copy(String fromBucket, String fromFileKey, String toBucket, String toFileKey)
            throws QiniuException {
        copy(fromBucket, fromFileKey, toBucket, toFileKey, false);
    }


    /**
     * 绉诲姩鏂囦欢锛岃姹傜┖闂村湪鍚屼竴璐﹀彿涓�
     *
     * @param fromBucket  婧愮┖闂村悕绉�
     * @param fromFileKey 婧愭枃浠跺悕绉�
     * @param toBucket    鐩殑绌洪棿鍚嶇О
     * @param toFileKey   鐩殑鏂囦欢鍚嶇О
     * @param force       寮哄埗瑕嗙洊绌洪棿涓凡鏈夊悓鍚嶏紙鍜� toFileKey 鐩稿悓锛夌殑鏂囦欢
     * @throws QiniuException
     */
    public Response move(String fromBucket, String fromFileKey, String toBucket,
                         String toFileKey, boolean force) throws QiniuException {
        String from = encodedEntry(fromBucket, fromFileKey);
        String to = encodedEntry(toBucket, toFileKey);
        String path = String.format("/move/%s/%s/force/%s", from, to, force);
        return rsPost(fromBucket, path, null);
    }

    /**
     * 绉诲姩鏂囦欢銆傝姹傜┖闂村湪鍚屼竴璐﹀彿涓�, 鍙互娣诲姞force鍙傛暟涓簍rue寮鸿绉诲姩鏂囦欢銆�
     *
     * @param fromBucket  婧愮┖闂村悕绉�
     * @param fromFileKey 婧愭枃浠跺悕绉�
     * @param toBucket    鐩殑绌洪棿鍚嶇О
     * @param toFileKey   鐩殑鏂囦欢鍚嶇О
     * @throws QiniuException
     */
    public Response move(String fromBucket, String fromFileKey, String toBucket, String toFileKey)
            throws QiniuException {
        return move(fromBucket, fromFileKey, toBucket, toFileKey, false);
    }


    /**
     * 鎶撳彇鎸囧畾鍦板潃鐨勬枃浠讹紝浠ユ寚瀹氬悕绉颁繚瀛樺湪鎸囧畾绌洪棿
     * 瑕佹眰鎸囧畾url鍙闂紝澶ф枃浠朵笉寤鸿浣跨敤姝ゆ帴鍙ｆ姄鍙栥�傚彲鍏堜笅杞藉啀涓婁紶
     * 濡傛灉涓嶆寚瀹氫繚瀛樼殑鏂囦欢鍚嶏紝閭ｄ箞浠ユ枃浠跺唴瀹圭殑 etag 浣滀负鏂囦欢鍚�
     *
     * @param url    寰呮姄鍙栫殑鏂囦欢閾炬帴
     * @param bucket 鏂囦欢鎶撳彇鍚庝繚瀛樼殑绌洪棿
     * @throws QiniuException
     */
    public FetchRet fetch(String url, String bucket) throws QiniuException {
        return fetch(url, bucket, null);
    }

    /**
     * 鎶撳彇鎸囧畾鍦板潃鐨勬枃浠讹紝宸叉寚瀹氬悕绉颁繚瀛樺湪鎸囧畾绌洪棿
     * 瑕佹眰鎸囧畾url鍙闂紝澶ф枃浠朵笉寤鸿浣跨敤姝ゆ帴鍙ｆ姄鍙栥�傚彲鍏堜笅杞藉啀涓婁紶
     *
     * @param url    寰呮姄鍙栫殑鏂囦欢閾炬帴
     * @param bucket 鏂囦欢鎶撳彇鍚庝繚瀛樼殑绌洪棿
     * @param key    鏂囦欢鎶撳彇鍚庝繚瀛樼殑鏂囦欢鍚�
     * @throws QiniuException
     */
    public FetchRet fetch(String url, String bucket, String key) throws QiniuException {
        String resource = UrlSafeBase64.encodeToString(url);
        String to = encodedEntry(bucket, key);
        String path = String.format("/fetch/%s/to/%s", resource, to);
        Response r = ioPost(bucket, path);
        return r.jsonToObject(FetchRet.class);
    }

    /**
     * 瀵逛簬璁剧疆浜嗛暅鍍忓瓨鍌ㄧ殑绌洪棿锛屼粠闀滃儚婧愮珯鎶撳彇鎸囧畾鍚嶇О鐨勮祫婧愬苟瀛樺偍鍒拌绌洪棿涓�
     * 濡傛灉璇ョ┖闂翠腑宸插瓨鍦ㄨ鍚嶇О鐨勮祫婧愶紝鍒欎細灏嗛暅鍍忔簮绔欑殑璧勬簮瑕嗙洊绌洪棿涓浉鍚屽悕绉扮殑璧勬簮
     *
     * @param bucket 绌洪棿鍚嶇О
     * @param key    鏂囦欢鍚嶇О
     * @throws QiniuException
     */
    public void prefetch(String bucket, String key) throws QiniuException {
        String resource = encodedEntry(bucket, key);
        String path = String.format("/prefetch/%s", resource);
        ioPost(bucket, path);
    }

    /**
     * 璁剧疆绌洪棿鐨勯暅鍍忔簮绔�
     *
     * @param bucket     绌洪棿鍚嶇О
     * @param srcSiteUrl 闀滃儚鍥炴簮鍦板潃
     */
    public Response setImage(String bucket, String srcSiteUrl) throws QiniuException {
        return setImage(bucket, srcSiteUrl, null);
    }

    /**
     * 璁剧疆绌洪棿鐨勯暅鍍忔簮绔�
     *
     * @param bucket     绌洪棿鍚嶇О
     * @param srcSiteUrl 闀滃儚鍥炴簮鍦板潃
     * @param host       闀滃儚鍥炴簮Host
     */
    public Response setImage(String bucket, String srcSiteUrl, String host) throws QiniuException {
        String encodedSiteUrl = UrlSafeBase64.encodeToString(srcSiteUrl);
        String encodedHost = null;
        if (host != null && host.length() > 0) {
            encodedHost = UrlSafeBase64.encodeToString(host);
        }
        String path = String.format("/image/%s/from/%s", bucket, encodedSiteUrl);
        if (encodedHost != null) {
            path += String.format("/host/%s", encodedHost);
        }
        return pubPost(path);
    }

    /**
     * 鍙栨秷绌洪棿鐨勯暅鍍忔簮绔欒缃�
     *
     * @param bucket 绌洪棿鍚嶇О
     */
    public Response unsetImage(String bucket) throws QiniuException {
        String path = String.format("/unimage/%s", bucket);
        return pubPost(path);
    }

    /**
     * 璁剧疆鏂囦欢鐨勫瓨娲绘椂闂�
     *
     * @param bucket 绌洪棿鍚嶇О
     * @param key    鏂囦欢鍚嶇О
     * @param days   瀛樻椿鏃堕棿锛屽崟浣嶏細澶�
     */
    public Response deleteAfterDays(String bucket, String key, int days) throws QiniuException {
        return rsPost(bucket, String.format("/deleteAfterDays/%s/%d", encodedEntry(bucket, key), days), null);
    }

    /*
    * 鐩稿叧璇锋眰鐨勬柟娉曞垪琛�
    * */

    private Response rsPost(String bucket, String path, byte[] body) throws QiniuException {
        check(bucket);
        String url = configuration.rsHost(auth.accessKey, bucket) + path;
        return post(url, body);
    }

    private Response rsGet(String bucket, String path) throws QiniuException {
        check(bucket);
        String url = configuration.rsHost(auth.accessKey, bucket) + path;
        return get(url);
    }

    private Response ioPost(String bucket, String path) throws QiniuException {
        check(bucket);
        String url = configuration.ioHost(auth.accessKey, bucket) + path;
        return post(url, null);
    }

    private Response pubPost(String path) throws QiniuException {
        String url = "http://pu.qbox.me:10200" + path;
        return post(url, null);
    }

    private Response get(String url) throws QiniuException {
        StringMap headers = auth.authorization(url);
        return client.get(url, headers);
    }

    private Response post(String url, byte[] body) throws QiniuException {
        StringMap headers = auth.authorization(url, body, Client.FormMime);
        return client.post(url, body, headers, Client.FormMime);
    }

    private void check(String bucket) throws QiniuException {
        if (StringUtils.isNullOrEmpty(bucket)) {
            throw new QiniuException(Response.createError(null, null, 0, "鏈寚瀹氭搷浣滅殑绌洪棿鎴栨搷浣滀綋涓虹┖"));
        }
    }

    /**
     * 鎵归噺鏂囦欢绠＄悊璇锋眰
     */
    public Response batch(BatchOperations operations) throws QiniuException {
        return rsPost(operations.execBucket(), "/batch", operations.toBody());
    }

    /**
     * 鏂囦欢绠＄悊鎵归噺鎿嶄綔鎸囦护鏋勫缓瀵硅薄
     */
    public static class BatchOperations {
        private ArrayList<String> ops;
        private String execBucket = null;

        public BatchOperations() {
            this.ops = new ArrayList<String>();
        }

        /**
         * 娣诲姞chgm鎸囦护
         */

        public BatchOperations addChgmOp(String bucket, String key, String newMimeType) {
            String resource = encodedEntry(bucket, key);
            String encodedMime = UrlSafeBase64.encodeToString(newMimeType);
            ops.add(String.format("/chgm/%s/mime/%s", resource, encodedMime));
            setExecBucket(bucket);
            return this;
        }

        /**
         * 娣诲姞copy鎸囦护
         */
        public BatchOperations addCopyOp(String fromBucket, String fromFileKey, String toBucket, String toFileKey) {
            String from = encodedEntry(fromBucket, fromFileKey);
            String to = encodedEntry(toBucket, toFileKey);
            ops.add(String.format("copy/%s/%s", from, to));
            setExecBucket(fromBucket);
            return this;
        }

        /**
         * 娣诲姞閲嶅懡鍚嶆寚浠�
         */
        public BatchOperations addRenameOp(String fromBucket, String fromFileKey, String toFileKey) {
            return addMoveOp(fromBucket, fromFileKey, fromBucket, toFileKey);
        }

        /**
         * 娣诲姞move鎸囦护
         */
        public BatchOperations addMoveOp(String fromBucket, String fromKey, String toBucket, String toKey) {
            String from = encodedEntry(fromBucket, fromKey);
            String to = encodedEntry(toBucket, toKey);
            ops.add(String.format("move/%s/%s", from, to));
            setExecBucket(fromBucket);
            return this;
        }

        /**
         * 娣诲姞delete鎸囦护
         */
        public BatchOperations addDeleteOp(String bucket, String... keys) {
            for (String key : keys) {
                ops.add(String.format("delete/%s", encodedEntry(bucket, key)));
            }
            setExecBucket(bucket);
            return this;
        }

        /**
         * 娣诲姞stat鎸囦护
         */
        public BatchOperations addStatOps(String bucket, String... keys) {
            for (String key : keys) {
                ops.add(String.format("stat/%s", encodedEntry(bucket, key)));
            }
            setExecBucket(bucket);
            return this;
        }

        public byte[] toBody() {
            String body = StringUtils.join(ops, "&op=", "op=");
            return StringUtils.utf8Bytes(body);
        }

        public BatchOperations merge(BatchOperations batch) {
            this.ops.addAll(batch.ops);
            setExecBucket(batch.execBucket());
            return this;
        }

        public BatchOperations clearOps() {
            this.ops.clear();
            return this;
        }

        private void setExecBucket(String bucket) {
            if (execBucket == null) {
                execBucket = bucket;
            }
        }

        public String execBucket() {
            return execBucket;
        }
    }

    /**
     * 鍒涘缓鏂囦欢鍒楄〃杩唬鍣�
     */
    public class FileListIterator implements Iterator<FileInfo[]> {
        private String marker = null;
        private String bucket;
        private String delimiter;
        private int limit;
        private String prefix;
        private QiniuException exception = null;

        public FileListIterator(String bucket, String prefix, int limit, String delimiter) {
            if (limit <= 0) {
                throw new IllegalArgumentException("limit must greater than 0");
            }
            if (limit > 1000) {
                throw new IllegalArgumentException("limit must not greater than 1000");
            }
            this.bucket = bucket;
            this.prefix = prefix;
            this.limit = limit;
            this.delimiter = delimiter;
        }

        public QiniuException error() {
            return exception;
        }

        @Override
        public boolean hasNext() {
            return exception == null && !"".equals(marker);
        }

        @Override
        public FileInfo[] next() {
            try {
                FileListing f = listFiles(bucket, prefix, marker, limit, delimiter);
                this.marker = f.marker == null ? "" : f.marker;
                return f.items;
            } catch (QiniuException e) {
                this.exception = e;
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}

