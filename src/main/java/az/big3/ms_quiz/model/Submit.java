package az.big3.ms_quiz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Submit {
    //Question's id its stored in array so its id its index in list
    private String questionId;

    //user's answer index for example he chose B variant its index is 1;
    private int answerIndex;
}
