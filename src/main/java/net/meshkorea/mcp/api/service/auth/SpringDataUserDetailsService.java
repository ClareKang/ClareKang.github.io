package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.repository.AuthorityRepository;
import net.meshkorea.mcp.api.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jihunlee on 2016. 1. 12..
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(SpringDataUserDetailsService.class);

    private boolean enableAuthorities = true;
    private boolean enableGroups;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    private String rolePrefix = "";

    protected void addCustomAuthorities(String userName, Set<GrantedAuthority> authorities) {
    }

    protected void initService() throws ApplicationContextException {
        Assert.isTrue(enableAuthorities || enableGroups,
            "Use of either authorities or groups must be enabled");
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findOneByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(
                MessageFormat.format("Username {0} not found", userName));
        }

        Set<GrantedAuthority> dbAuthSet = new HashSet<>();

        return createUserDetails(user, dbAuthSet);
    }

    protected UserDetails createUserDetails(User user, Collection<? extends GrantedAuthority> combinedAuthorities) {
        return new org.springframework.security.core.userdetails.User("", "", combinedAuthorities);
    }

    protected String getRolePrefix() {
        return rolePrefix;
    }

    /**
     * Allows a default role prefix to be specified. If this is set to a non-empty value,
     * then it is automatically prepended to any roles read in from the db. This may for
     * example be used to add the <tt>ROLE_</tt> prefix expected to exist in role names
     * (by default) by some other Spring Security classes, in the case that the prefix is
     * not already present in the db.
     *
     * @param rolePrefix the new prefix
     */
    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }

    protected boolean getEnableAuthorities() {
        return enableAuthorities;
    }

    /**
     * Enables loading of authorities (roles) from the authorities table. Defaults to true
     */
    public void setEnableAuthorities(boolean enableAuthorities) {
        this.enableAuthorities = enableAuthorities;
    }

    protected boolean getEnableGroups() {
        return enableGroups;
    }

    /**
     * Enables support for group authorities. Defaults to false
     *
     * @param enableGroups
     */
    public void setEnableGroups(boolean enableGroups) {
        this.enableGroups = enableGroups;
    }
}
