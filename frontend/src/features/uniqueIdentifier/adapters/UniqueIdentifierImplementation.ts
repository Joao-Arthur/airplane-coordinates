const allowedCharacters = [
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
] as const;

export class UniqueIdentifierImplementation {
    private indexes = [] as number[];

    private increaseIndex(digitPosition: number) {
        if (this.indexes[digitPosition] === undefined)
            this.indexes[digitPosition] = -1;
        this.indexes[digitPosition]++;
        if (this.indexes[digitPosition] >= allowedCharacters.length) {
            this.indexes[digitPosition] = 0;
            this.increaseIndex(digitPosition + 1);
        }
    }

    public getUnique() {
        this.increaseIndex(0);
        return [...this.indexes.map(index => allowedCharacters[index])].reverse().join('');
    }
}
