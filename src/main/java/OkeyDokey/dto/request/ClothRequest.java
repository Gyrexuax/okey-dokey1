package OkeyDokey.dto.request;

import OkeyDokey.constants.ErrorMessage;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class ClothRequest {
    private Long id;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String clothTitle;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String clother;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String clothType;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String clothGender;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String color;

    private String description;
    private String filename;

    @NotNull(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Min(value = 1, message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    private Integer price;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String size;

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String type;
}
