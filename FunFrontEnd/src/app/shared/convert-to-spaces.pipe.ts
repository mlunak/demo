import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: "convertToSpaces"
})
export class ConvertToSpacesPipe implements PipeTransform {
    transform(value: string, characterString: string, whatever?: number) {
        if (whatever == 1) {
            return value.replace(characterString, '')
        }
        return value.replace(characterString, ' ')
    }
}