package koreatech.cse.domain.oauth2.daum;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "channel"
})
public class DaumBook {

    @JsonProperty("channel")
    private Channel channel;

    /**
     *
     * @return
     * The channel
     */
    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    /**
     *
     * @param channel
     * The channel
     */
    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "DaumBook{" +
                "channel=" + channel +
                '}';
    }
}