package pl.pwojaczek.vouchershop.sales;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientData {
    @NotNull
    String firstname;
    @NotNull
    String lastname;
    @NotNull
    String email;
}
