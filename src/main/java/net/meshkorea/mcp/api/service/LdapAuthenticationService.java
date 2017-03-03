package net.meshkorea.mcp.api.service;

import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by sungjae.hong on 2017. 2. 27..
 */
@Service
public class LdapAuthenticationService {
    public Object getLdapUserData(String uid){
        Hashtable env = new Hashtable(11);
        ArrayList<Attribute> cn = new ArrayList<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://10.5.1.251:389/");
        env.put(Context.SECURITY_AUTHENTICATION, "none");

        try {
            LdapContext ctx = new InitialLdapContext(env, null);
            ctx.setRequestControls(null);
            NamingEnumeration<?> namingEnum = ctx.search("uid="+uid+",ou=people,dc=meshcorp,dc=com", "(objectclass=*)", getSimpleSearchControls());
            while (namingEnum.hasMore()) {
                SearchResult result = (SearchResult) namingEnum.next();
                Attributes attrs = result.getAttributes();
                System.out.println(attrs.toString());
                cn.add(attrs.get("cn"));

            }
            namingEnum.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }

    private static SearchControls getSimpleSearchControls() {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(30000);
        //String[] attrIDs = {"objectGUID"};
        //searchControls.setReturningAttributes(attrIDs);
        return searchControls;
    }
}
