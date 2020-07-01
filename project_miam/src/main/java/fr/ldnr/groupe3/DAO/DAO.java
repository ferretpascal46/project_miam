package fr.ldnr.groupe3.DAO;

import java.util.List;
import java.sql.Connection;

public abstract class DAO<T> {

	// Faut faire avec hibernate du coup ?
	// protected Connection connection = MySQLConnection.getInstance();

	/**
	 * Permet de rÃ©cupÃ©rer un objet via son ID
	 *
	 * @param id
	 * @return lâ€™objet recherchÃ©
	 */
	public abstract T find(Long id);

	/**
	 * Permet de crÃ©er une entrÃ©e dans la base de donnÃ©es par rapport Ã  un objet
	 *
	 * @param obj
	 * @return lâ€™objet crÃ©Ã© avec son id
	 */
	public abstract T create(T obj);

	/**
	 * Permet de mettre Ã  jour les donnÃ©es d'une entrÃ©e dans la base
	 *
	 * @param obj
	 * @return lâ€™objet modifiÃ©
	 */
	public abstract T update(T obj);

	/**
	 * Permet la suppression d'une entrÃ©e de la base
	 *
	 * @param obj
	 */
	public abstract void delete(T obj);

	/**
	 * RÃ©cupÃ¨re toutes les donnÃ©es de la table
	 *
	 * @return Toutes les donnÃ©es sous forme de liste
	 */
	public abstract List<T> list();

}
