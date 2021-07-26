export class Pageable {

    constructor(
        public page?: number,
        public size?: number,
        public sort?: string,
    ) {
    }

    setSort(sortOrder: number, sortField: string) {
        const direction = sortOrder === 1 ? 'ASC' : 'DESC';
        this.sort = sortField + ',' + direction;
    }
}
