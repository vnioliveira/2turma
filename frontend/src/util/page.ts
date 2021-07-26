export class Page<T> {
    constructor(
        public content?: T[],
        public numberOfElements?: number,
        public totalElements?: number,
        public pageable?: { offset?: number }
    ) { }
}
