import { Usuario } from "../usuario";

export interface Post {
    id: string;
    authorId: string;
    author?: Usuario;
    content?: string;
    mediaUrls?: string[];
    likesCount: number;
    comments: string[];
    commentsCount: number;
    createdAt?: string;
    updatedAt?: string;
}