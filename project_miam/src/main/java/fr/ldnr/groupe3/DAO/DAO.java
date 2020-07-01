package fr.ldnr.groupe3.DAO;

import java.util.List;

public abstract class DAO<T> {

	/**
	 * Permet de créer une entrée dans la base de données par rapport à un objet
	 *
	 * @param obj
	 * @return l'objet créé avec son id
	 */
	public abstract T create(T obj);

	/**
	 * Permet de mettre a jour les données d'une entrée dans la base
	 *
	 * @param obj
	 * @return lâ€™objet modifiÃ©
	 */
	public abstract T update(T obj);

	/**
	 * Permet la suppression d'une entrée de la base
	 *
	 * @param obj
	 */
	public abstract void delete(T obj);

	/**
	 * Récupère toutes les données de la table
	 *
	 * @return Toutes les données sous forme de liste
	 */
	public abstract List<T> list();

}
