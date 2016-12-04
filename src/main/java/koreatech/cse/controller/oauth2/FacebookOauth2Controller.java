package koreatech.cse.controller.oauth2;

import koreatech.cse.domain.oauth2.facebook.FacebookLike;
import koreatech.cse.domain.oauth2.facebook.FacebookProfile;
import koreatech.cse.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/oauth2")
public class FacebookOauth2Controller {
    private static String facebook_client_id = "219784461791241";      //본인 것으로 추가하기
    private static String facebook_client_secret = "8adfd6d3c00d3cf54c552efd2fb3f3e3";  //본인 것으로 추가하기
    private static String facebook_authorization_endpoint = "https://www.facebook.com/dialog/oauth";
    private static String facebook_token_endpoint = "https://graph.facebook.com/v2.5/oauth/access_token";

    private static String facebook_redirect_uri = "http://localhost:8080/oauth2/facebook_callback";

    private static String facebook_profile_url = "https://graph.facebook.com/v2.8/me?access_token=";
    private static String facebook_likes_url = "https://graph.facebook.com/v2.8/me/likes?access_token=";


    @Inject
    private UserService userService;

    private OAuth2Template facebookOAuth2Template = new OAuth2Template(
            facebook_client_id,
            facebook_client_secret,
            facebook_authorization_endpoint,
            facebook_token_endpoint
    );

    private HashMap<String, AccessGrant> facebookAccessToken = new HashMap();

    @RequestMapping("/facebook_authorization_code")
    public String facebook_authorization_code() {
        OAuth2Parameters parameters = new OAuth2Parameters();
        parameters.setRedirectUri(facebook_redirect_uri);
        parameters.setScope("public_profile,email,user_friends,user_likes");

        String authorizeUrl = facebookOAuth2Template.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, parameters);
        System.out.println("authorizeUrl: " + authorizeUrl);

        return "redirect:" + authorizeUrl;
    }

    @RequestMapping("/facebook_callback")
    public String facebook_callback(Model model, HttpServletRequest request, @RequestParam(required=true) String code) throws Exception {
        System.out.println("Facebook Callback is called!!");
        System.out.println(code);

        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setOutputStreaming(false);
        facebookOAuth2Template.setRequestFactory(simpleClientHttpRequestFactory);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        multiValueMap.add("client_id", facebook_client_id);
        multiValueMap.add("client_secret", facebook_client_secret);

        AccessGrant accessGrant = facebookOAuth2Template.exchangeForAccess(
                code,
                facebook_redirect_uri,
                multiValueMap
        );

        System.out.println("------ AccessGrant ------");
        System.out.println(accessGrant.getAccessToken());
        System.out.println(accessGrant.getRefreshToken());
        System.out.println(accessGrant.getExpireTime());
        System.out.println(accessGrant.getScope());
        System.out.println();

        FacebookProfile facebookProfile = getFacebookProfile(accessGrant);
        if (facebookProfile != null) {
            facebookAccessToken.put(facebookProfile.getId(), accessGrant);
        }

        return userService.facebookLogin(request, facebookProfile);
    }

    public FacebookProfile getFacebookProfile(AccessGrant accessGrant) {
        RestTemplate restTemplate = new RestTemplate();
        FacebookProfile facebookProfile = null;
        try {
            ResponseEntity<FacebookProfile> facebookProfileResponseEntity
                    = restTemplate.getForEntity(facebook_profile_url + accessGrant.getAccessToken(), FacebookProfile.class);
            facebookProfile = facebookProfileResponseEntity.getBody();
            System.out.println(facebookProfile);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
        return facebookProfile;
    }

    @RequestMapping(value = "/facebook_likes_request", method = RequestMethod.GET)
    public String facebookFriendsRequest(Model model, @RequestParam(name = "userId") String userId) {
        model.addAttribute("userId", userId);
        return "wsc/facebookLikesRequest";
    }

    @RequestMapping("/facebookLikes")
    public String getFacebookLikes(Model model,
                                   @RequestParam(name = "userId") String userId) {
        RestTemplate restTemplate = new RestTemplate();
        FacebookLike facebookLike = null;
        AccessGrant accessGrant = facebookAccessToken.get(userId);
        try {
            ResponseEntity<FacebookLike> facebookFriendsResponseEntity
                    = restTemplate.getForEntity(facebook_likes_url + accessGrant.getAccessToken(), FacebookLike.class);
            facebookLike = facebookFriendsResponseEntity.getBody();
            System.out.println(facebookLike);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
        model.addAttribute("userId", userId);
        model.addAttribute("facebookLike", facebookLike);
        return "wsc/facebookLikes";
    }
}