package net.meshkorea.mcp.api.domain.model.azure;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by yjhan on 2017. 6. 25..
 */
@Getter
@Setter
public class AdUserSimple {

    /**
     * The unique identifier for the user.
     * Inherited from directoryObject.
     * <p>
     * Key. Not nullable. Read-only.
     */
    private String id;

    /**
     * The telephone numbers for the user.
     * NOTE: Although this is a string collection, only one number can be set for this property.
     */
    private List<String> businessPhones;

    /**
     * The name displayed in the address book for the user.
     * This is usually the combination of the user's first name, middle initial and last name.
     * This property is required when a user is created and it cannot be cleared during updates.
     * <p>
     * Supports $filter and $orderby.
     */
    private String displayName;

    /**
     * The given name (first name) of the user.
     * <p>
     * Supports $filter.
     */
    private String givenName;

    /**
     * The user’s job title.
     * <p>
     * Supports $filter.
     */
    private String jobTitle;

    /**
     * The SMTP address for the user, for example, "jeff@contoso.onmicrosoft.com".
     * <p>
     * Read-Only. Supports $filter.
     */
    private String mail;

    /**
     * The primary cellular telephone number for the user.
     */
    private String mobilePhone;

    /**
     * The office location in the user's place of business.
     */
    private String officeLocation;

    /**
     * The preferred language for the user.
     * Should follow ISO 639-1 Code; for example "en-US".
     */
    private String preferredLanguage;

    /**
     * The user's surname (family name or last name).
     * <p>
     * Supports $filter.
     */
    private String surname;

    /**
     * The user principal name (UPN) of the user.
     * The UPN is an Internet-style login name for the user based on the Internet standard RFC 822.
     * By convention, this should map to the user's email name.
     * The general format is alias@domain, where domain must be present in the tenant’s collection of verified domains.
     * This property is required when a user is created.
     * The verified domains for the tenant can be accessed from the verifiedDomains property of organization.
     * <p>
     * Supports $filter and $orderby.
     */
    private String userPrincipalName;
}
