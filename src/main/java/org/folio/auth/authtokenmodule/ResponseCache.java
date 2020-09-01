package org.folio.auth.authtokenmodule;

import java.util.HashMap;
import java.util.Map;

import io.vertx.core.json.JsonObject;

public class ResponseCache {

  private Map<String, JsonObject> cache = new HashMap<>();
  
  public void put(String method, String path, String modPerms, JsonObject resp) {
    cache.put(genKey(method, path, modPerms), resp);
  }
  
  public JsonObject get(String method, String path, String modPerms) {
    return cache.get(genKey(method, path, modPerms));
  }
  
  private String genKey(String method, String path, String modPerms) {
    return method+"|"+path+"|"+modPerms;
  }
}
